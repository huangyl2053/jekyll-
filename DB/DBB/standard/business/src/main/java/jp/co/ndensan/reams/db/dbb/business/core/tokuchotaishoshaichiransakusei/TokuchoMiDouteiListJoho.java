/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchotaishoshaichiransakusei.TokuchoTaishoshaIchiranSakuseiEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.SeibetsuCodeNenkinTokucho;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別徴収未同定一覧情報<br/>
 * ビジネス設計_DBBBZ81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-030 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoMiDouteiListJoho {

    private RString 確認状況;
    private RString 不一致理由;
    private RString 捕捉月;
    private RString 年金番号;
    private RString 年金コード;
    private RString 特別徴収義務者;
    private RString カナ氏名;
    private RString 生年月日;
    private RString 性別;
    private RString 漢字氏名;
    private RString 郵便番号;
    private RString 住所;
    private RString 住民種別コード;

    /**
     * コンストラクタです。
     *
     * @param resultEntity TokuchoTaishoshaIchiranSakuseiEntity
     */
    public TokuchoMiDouteiListJoho(TokuchoTaishoshaIchiranSakuseiEntity resultEntity) {
        if (resultEntity != null && resultEntity.getDbt2019entity() != null) {
            this.確認状況 = resultEntity.getDbt2019entity().getKakuninJokyoKbn();
            this.不一致理由 = resultEntity.getDbt2019entity().getFuichiRiyuCode();
            this.捕捉月 = resultEntity.getDbt2019entity().getHosokuM();
            this.年金番号 = resultEntity.getDbt2019entity().getKisoNenkinNo();
            this.年金コード = resultEntity.getDbt2019entity().getNenkinCode();
        }
        if (resultEntity != null && resultEntity.getUet0511entity() != null) {
            TokubetsuChoshuGimushaCode gimushaCode = resultEntity.getUet0511entity().getDtTokubetsuChoshuGimushaCode();
            Code code = gimushaCode == null ? null : gimushaCode.value();
            if (code != null) {
                this.特別徴収義務者 = code.value();
            }
            this.カナ氏名 = resultEntity.getUet0511entity().getDtKanaShimei();
            this.生年月日 = resultEntity.getUet0511entity().getDtBirthDay();
            SeibetsuCodeNenkinTokucho seibetsuCode = resultEntity.getUet0511entity().getDtSeibetsu();
            this.性別 = seibetsuCode == null ? RString.EMPTY : seibetsuCode.value().get性別コード();
        }
    }
}
