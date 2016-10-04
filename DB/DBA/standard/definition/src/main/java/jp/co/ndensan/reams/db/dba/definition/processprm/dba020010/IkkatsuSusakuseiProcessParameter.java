/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.dba020010;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshadaicho.IkkatsuSakuseiMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 被保険者台帳一括作成のバッチ処理クラスのパラメータ
 *
 * @reamsid_L DBA-0510-010 duanzhanli
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class IkkatsuSusakuseiProcessParameter implements IBatchProcessParameter {

    private boolean chushutsuFlag;
    private boolean shutsuryokuFlag;
    private Long shutsuryokujunId;
    private LasdecCode shichosonCode;
    private ShikibetsuCode shikibetsuCode;
    private RString psmShikibetsuTaisho;
    private RString orderby;
    private RString loginUserId;

    /**
     * コンストラクタ
     *
     * @param 資格喪失者抽出フラグ 資格喪失者抽出フラグ
     * @param 出力フラグ 出力フラグ
     * @param 出力順ID 出力順ID
     * @param 登録ユーザーID 登録ユーザーID
     */
    public IkkatsuSusakuseiProcessParameter(boolean 資格喪失者抽出フラグ,
            boolean 出力フラグ,
            Long 出力順ID,
            RString 登録ユーザーID) {
        this.chushutsuFlag = 資格喪失者抽出フラグ;
        this.shutsuryokuFlag = 出力フラグ;
        this.shutsuryokujunId = 出力順ID;
        this.loginUserId = 登録ユーザーID;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public IkkatsuSakuseiMybatisParameter toIkkatsuHakkoMybatisParameter() {
        return IkkatsuSakuseiMybatisParameter.createSelectByKeyParam(chushutsuFlag,
                shichosonCode,
                shikibetsuCode,
                psmShikibetsuTaisho,
                orderby);
    }
}
