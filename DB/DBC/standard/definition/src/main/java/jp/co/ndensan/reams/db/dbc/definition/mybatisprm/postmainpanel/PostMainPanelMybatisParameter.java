/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.postmainpanel;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBC0510011_国保・後期高齢資格異動情報取込
 *
 * @reamsid_L DBC-3020-010 chenyadong
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class PostMainPanelMybatisParameter implements IMyBatisParameter {

    private final RString 処理名;
    private final RString 市町村識別ID;
    private final boolean 後期高齢者情報取り込み;
    private final boolean 国保情報取り込み;
    private final RString 処理名_国保情報取り込み = new RString("国保情報取り込み");
    private final RString 処理名_後期高齢者情報取り込み = new RString("後期高齢者情報取り込み");

    /**
     * コンストラクタです。
     *
     * @param 市町村識別ID RString
     * @param 処理名 RString
     */
    protected PostMainPanelMybatisParameter(RString 処理名, RString 市町村識別ID) {
        this.処理名 = 処理名;
        if (this.処理名.equals(処理名_国保情報取り込み)) {
            this.国保情報取り込み = true;
            this.後期高齢者情報取り込み = false;
        } else {
            if (this.処理名.equals(処理名_後期高齢者情報取り込み)) {
                this.国保情報取り込み = false;
                this.後期高齢者情報取り込み = true;
            } else {
                throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                        .replace("処理名").evaluate());
            }

        }
        this.市町村識別ID = 市町村識別ID;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param 市町村識別ID RString
     * @param 処理名 RString
     * @return PostMainPanelMybatisParameter
     */
    public static PostMainPanelMybatisParameter creatParameter(RString 処理名, RString 市町村識別ID) {
        return new PostMainPanelMybatisParameter(処理名, 市町村識別ID);
    }
}
