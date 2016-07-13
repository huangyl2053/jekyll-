/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei;

import jp.co.ndensan.reams.db.dbb.entity.db.tokuchotaishoshaichiransakusei.TokuchoTaishoshaIchiranSakuseiEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別徴収同定一覧情報<br/>
 * ビジネス設計_DBBBZ81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-030 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoDouteiListJoho {

    private RString 被保険者番号;
    private RString 識別コード;
    private RString 漢字氏名;
    private RString 捕捉月;
    private RString 特徴義務者コード;
    private RString 基礎年金番号;
    private RString 年金コード;
    private RString 生年月日;
    private RString 性別コード;
    private RString 住所;
    private RString 世帯コード;
    private RString 行政区コード;
    private RString カナ氏名_上段;
    private RString カナ氏名_下段;
    private RString 郵便番号;
    private RString 住民種別コード;

    /**
     * コンストラクタです。
     *
     * @param resultEntity TokuchoTaishoshaIchiranSakuseiEntity
     */
    public TokuchoDouteiListJoho(TokuchoTaishoshaIchiranSakuseiEntity resultEntity) {
        if (resultEntity != null && resultEntity.getDbt1001entity() != null) {
            if (resultEntity.getDbt1001entity().getHihokenshaNo() != null) {
                this.被保険者番号 = resultEntity.getDbt1001entity().getHihokenshaNo().value();
            }
            if (resultEntity.getDbt1001entity().getShikibetsuCode() != null) {
                this.識別コード = resultEntity.getDbt1001entity().getShikibetsuCode().value();
            }
        }
        if (resultEntity != null && resultEntity.getUet0511entity() != null) {
            this.漢字氏名 = resultEntity.getUet0511entity().getDtKanjiShimei();
            this.捕捉月 = resultEntity.getUet0511entity().getHosokuTsuki();
            this.基礎年金番号 = resultEntity.getUet0511entity().getKisoNenkinNo();
            this.年金コード = resultEntity.getUet0511entity().getNenkinCode();
            this.生年月日 = resultEntity.getUet0511entity().getDtBirthDay();
            this.性別コード = resultEntity.getUet0511entity().getDtSeibetsu();
            this.住所 = resultEntity.getUet0511entity().getDtKanjiJusho();
            Code code = resultEntity.getUet0511entity().getDtTokubetsuChoshuGimushaCode();
            if (code != null) {
                this.特徴義務者コード = code.value();
            }
        }
    }
}
