/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210003;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3423
 */
public enum GaikyoTokkiYichiranNyurokuDivSpec implements IPredicate<GaikyoTokkiYichiranNyurokuDiv> {
    特記事項1の非空チェック {
                /**
                 * 特記事項1の非空チェックです。
                 *
                 * @param div GaikyoTokkiYichiranNyurokuDiv
                 * @return true:特記事項1が設定されている、false:特記事項1が設定されていない。
                 */
                @Override
                public boolean apply(GaikyoTokkiYichiranNyurokuDiv div) {
                    return !RString.isNullOrEmpty(div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().getValue());
                }
            },
    特記事項2の非空チェック {
                /**
                 * 特記事項2の非空チェックです。
                 *
                 * @param div GaikyoTokkiYichiranNyurokuDiv
                 * @return true:特記事項1が設定されている、false:特記事項1が設定されていない。
                 */
                @Override
                public boolean apply(GaikyoTokkiYichiranNyurokuDiv div) {
                    return !RString.isNullOrEmpty(div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().getValue());
                }
            },
    特記事項3の非空チェック {
                /**
                 * 特記事項3の非空チェックです。
                 *
                 * @param div GaikyoTokkiYichiranNyurokuDiv
                 * @return true:特記事項1が設定されている、false:特記事項1が設定されていない。
                 */
                @Override
                public boolean apply(GaikyoTokkiYichiranNyurokuDiv div) {
                    return !RString.isNullOrEmpty(div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().getValue());
                }
            },
    特記事項4の非空チェック {
                /**
                 * 特記事項4の非空チェックです。
                 *
                 * @param div GaikyoTokkiYichiranNyurokuDiv
                 * @return true:特記事項1が設定されている、false:特記事項1が設定されていない。
                 */
                @Override
                public boolean apply(GaikyoTokkiYichiranNyurokuDiv div) {
                    return !RString.isNullOrEmpty(div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().getValue());
                }
            },
    特記事項5の非空チェック {
                /**
                 * 特記事項5の非空チェックです。
                 *
                 * @param div GaikyoTokkiYichiranNyurokuDiv
                 * @return true:特記事項1が設定されている、false:特記事項1が設定されていない。
                 */
                @Override
                public boolean apply(GaikyoTokkiYichiranNyurokuDiv div) {
                    return !RString.isNullOrEmpty(div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().getValue());
                }
            }
}
