package model

import model.position.Position
import model.position.PositivePosition
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PositionTest {
    @Test
    fun `width, height, maxWidth, maxHeight 가 같으면 같은 Position 이다`() {
        assertThat(
            PositivePosition(IndexWithMax(1, 1), IndexWithMax(2, 2))
        ).isEqualTo(
            PositivePosition(IndexWithMax(1, 1), IndexWithMax(2, 2))
        )
    }

    @ParameterizedTest
    @MethodSource("aroundPositionsProvider")
    fun `aroundPositions`(position: Position, expected: List<Position>) {
        val result = position.aroundPositions()
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected)
        assertThat(result).doesNotContain(position)
    }

    companion object {
        @JvmStatic
        fun aroundPositionsProvider(): List<Arguments> {
            return listOf(
                Arguments {
                    arrayOf(
                        PositivePosition(
                            IndexWithMax(1, 2),
                            IndexWithMax(1, 2)
                        ),
                        listOf(
                            PositivePosition(
                                IndexWithMax(0, 2),
                                IndexWithMax(0, 2)
                            ),
                            PositivePosition(
                                IndexWithMax(0, 2),
                                IndexWithMax(1, 2)
                            ),
                            PositivePosition(
                                IndexWithMax(0, 2),
                                IndexWithMax(2, 2)
                            ),
                            PositivePosition(
                                IndexWithMax(1, 2),
                                IndexWithMax(0, 2)
                            ),
                            PositivePosition(
                                IndexWithMax(1, 2),
                                IndexWithMax(2, 2)
                            ),
                            PositivePosition(
                                IndexWithMax(2, 2),
                                IndexWithMax(0, 2)
                            ),
                            PositivePosition(
                                IndexWithMax(2, 2),
                                IndexWithMax(1, 2)
                            ),
                            PositivePosition(
                                IndexWithMax(2, 2),
                                IndexWithMax(2, 2)
                            )
                        )
                    )
                },
                Arguments {
                    arrayOf(
                        PositivePosition(
                            IndexWithMax(2, 2),
                            IndexWithMax(2, 2)
                        ),
                        listOf(
                            PositivePosition(
                                IndexWithMax(1, 2),
                                IndexWithMax(2, 2)
                            ),
                            PositivePosition(
                                IndexWithMax(2, 2),
                                IndexWithMax(1, 2)
                            ),
                            PositivePosition(
                                IndexWithMax(1, 2),
                                IndexWithMax(1, 2)
                            )
                        )
                    )
                },
                Arguments {
                    arrayOf(
                        PositivePosition(
                            IndexWithMax(0, 2),
                            IndexWithMax(1, 2)
                        ),
                        listOf(
                            PositivePosition(
                                IndexWithMax(0, 2),
                                IndexWithMax(0, 2)
                            ),
                            PositivePosition(
                                IndexWithMax(0, 2),
                                IndexWithMax(2, 2)
                            ),
                            PositivePosition(
                                IndexWithMax(1, 2),
                                IndexWithMax(0, 2)
                            ),
                            PositivePosition(
                                IndexWithMax(1, 2),
                                IndexWithMax(2, 2)
                            ),
                            PositivePosition(
                                IndexWithMax(1, 2),
                                IndexWithMax(1, 2)
                            )
                        )
                    )
                }
            )
        }
    }
}