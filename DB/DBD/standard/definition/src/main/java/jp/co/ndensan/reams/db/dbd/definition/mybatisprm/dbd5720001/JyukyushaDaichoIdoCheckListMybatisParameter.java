/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5720001;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者台帳異動チェックリスト(バッチ)SQLのパラメータクラス
 *
 * @reamsid_L DBD-1770-020 donghj
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JyukyushaDaichoIdoCheckListMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final RDate 今回抽出開始年月日;
    private final RDateTime 行挿入日時開始;
    private final RDate 今回抽出終了年月日;
    private final RDateTime 行挿入日時終了;
    private final RString 出力対象;
    private final RString 出力順;
    private final UaFt200FindShikibetsuTaishoParam psmShikibetsuTaisho;

    private final boolean is全て;
    private final boolean is申請者異動以外全て;
    private final boolean is申請者異動のみ;
    private boolean has今回抽出開始年月日;
    private boolean has今回抽出終了年月日;

    /**
     * コンストラクタです。
     *
     * @param 今回抽出開始年月日 今回抽出開始年月日
     * @param 行挿入日時開始 行挿入日時開始
     * @param 今回抽出終了年月日 今回抽出終了年月日
     * @param 行挿入日時終了 行挿入日時終了
     * @param 出力対象 出力対象
     * @param 出力順 出力順
     * @param shikibetsuTaishoPSMSearchKey 宛名識別対象PSM検索キー
     */
    public JyukyushaDaichoIdoCheckListMybatisParameter(RDate 今回抽出開始年月日, RDateTime 行挿入日時開始,
            RDate 今回抽出終了年月日, RDateTime 行挿入日時終了, RString 出力対象, RString 出力順,
            IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey) {
        super(shikibetsuTaishoPSMSearchKey);
        this.今回抽出開始年月日 = 今回抽出開始年月日;
        this.行挿入日時開始 = 行挿入日時開始;
        this.今回抽出終了年月日 = 今回抽出終了年月日;
        this.行挿入日時終了 = 行挿入日時終了;
        this.出力対象 = 出力対象;
        this.is全て = new RString("全て").equals(出力対象);
        this.is申請者異動以外全て = new RString("申請者異動以外全て").equals(出力対象);
        this.is申請者異動のみ = new RString("申請者異動のみ").equals(出力対象);
        this.出力順 = 出力順;
        if (今回抽出開始年月日 != null) {
            this.has今回抽出開始年月日 = true;
        }
        if (今回抽出終了年月日 != null) {
            this.has今回抽出終了年月日 = true;
        }
        this.psmShikibetsuTaisho = new UaFt200FindShikibetsuTaishoParam(shikibetsuTaishoPSMSearchKey);

    }

}
