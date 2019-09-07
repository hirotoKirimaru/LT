  @ParameterizedTest
  @ArgumentsSource(Taiueo.class)
  void fuga(Taiueo taiueo) {

    assertEquals(taiueo.result, target.canSetPlayerPiece(taiueo.player, taiueo.row, taiueo.column));
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  static class Taiueo implements ArgumentsProvider {
    private int player;
    private int row;
    private int column;
    private boolean result;

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Taiueo.builder().player(1).row(0).column(0).result(false).build(),
          Taiueo.builder().player(2).row(0).column(0).result(true).build(),
          Taiueo.builder().player(1).row(0).column(1).result(true).build()
      ).map(Arguments::of);
    }
  }