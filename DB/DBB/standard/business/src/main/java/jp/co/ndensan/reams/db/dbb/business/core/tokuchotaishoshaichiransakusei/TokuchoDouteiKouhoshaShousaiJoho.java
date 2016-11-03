/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchotaishoshaichiransakusei.TokuchoTaishoshaIchiranSakuseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別徴収同定候補者詳細情報<br/>
 * ビジネス設計_DBBBZ81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-030 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoDouteiKouhoshaShousaiJoho {

    private RString 未同定年金情報_基礎年金番号;
    private RString 未同定年金情報_年金コード;
    private RString 未同定年金情報_特別徴収義務者コード;
    private RString 未同定年金情報_氏名漢字;
    private RString 未同定年金情報_氏名カナ;
    private RString 未同定年金情報_住所漢字;
    private RString 未同定年金情報_住所カナ;
    private RString 未同定年金情報_生年月日;
    private RString 未同定年金情報_性別;
    private RString 未同定年金情報_連番;
    private RString 未同定年金情報_処理年度;
    private RString 住基情報_識別コード;
    private RString 住基情報_個人番号;
    private RString 住基情報_漢字氏名;
    private RString 住基情報_カナ氏名;
    private RString 住基情報_漢字住所;
    private RDate 住基情報_生年月日;
    private RString 住基情報_性別;
    private RString 住基情報_住民種別;
    private FlexibleDate 住基情報_住登日;
    private FlexibleDate 住基情報_消除日;
    private RString 被保険者台帳_被保険者番号;
    private RString 被保険者台帳_資格取得事由;
    private FlexibleDate 被保険者台帳_資格取得年月日;
    private FlexibleDate 被保険者台帳_資格喪失年月日;
    private RString 被保険者台帳_資格喪失事由;
    private RString 登録済年金情報_賦課年度;
    private RString 登録済年金情報_仮徴収基礎年金番号;
    private RString 登録済年金情報_仮徴収年金コード;
    private RString 登録済年金情報_仮徴収捕捉月;
    private RString 登録済年金情報_本徴収基礎年金番号;
    private RString 登録済年金情報_本徴収年金コード;
    private RString 登録済年金情報_本徴収捕捉月;
    private RString 登録済年金情報_翌年度仮徴収基礎年金番号;
    private RString 登録済年金情報_翌年度仮徴収年金コード;
    private RString 登録済年金情報_翌年度仮徴収捕捉月;
    private RString 登録済年金情報_基礎年金番号;
    private RString 登録済年金情報_年金コード;
    private RString 登録済年金情報_捕捉月;
    private RString 登録済年金情報_特別徴収義務者コード;

    /**
     * コンストラクタです。
     */
    public TokuchoDouteiKouhoshaShousaiJoho() {

    }

    /**
     * コンストラクタです。
     *
     * @param resultEntity TokuchoTaishoshaIchiranSakuseiEntity
     */
    public TokuchoDouteiKouhoshaShousaiJoho(TokuchoTaishoshaIchiranSakuseiEntity resultEntity) {
        if (resultEntity != null && resultEntity.getDbt2019entity() != null) {
            this.未同定年金情報_基礎年金番号 = resultEntity.getDbt2019entity().getKisoNenkinNo();
            this.未同定年金情報_年金コード = resultEntity.getDbt2019entity().getNenkinCode();
        }
        if (resultEntity != null && resultEntity.getUet0511entity() != null) {
            Code gimushaCode = resultEntity.getUet0511entity().getDtTokubetsuChoshuGimushaCode().value();
            if (gimushaCode != null) {
                this.未同定年金情報_特別徴収義務者コード = gimushaCode.value();
            }
            this.未同定年金情報_氏名漢字 = resultEntity.getUet0511entity().getDtKanjiShimei();
            this.未同定年金情報_氏名カナ = resultEntity.getUet0511entity().getDtKanaShimei();
            this.未同定年金情報_住所カナ = resultEntity.getUet0511entity().getDtKanaJusho();
            this.未同定年金情報_住所漢字 = resultEntity.getUet0511entity().getDtKanjiJusho();
            this.未同定年金情報_生年月日 = resultEntity.getUet0511entity().getDtBirthDay();
            RString seibetsu = resultEntity.getUet0511entity().getDtSeibetsu().getColumnValue();
            this.未同定年金情報_性別 = seibetsu;
            this.未同定年金情報_連番 = new RString(resultEntity.getUet0511entity().getRenban());
            if (resultEntity.getUet0511entity().getShoriNendo() != null) {
                this.未同定年金情報_処理年度 = resultEntity.getUet0511entity().getShoriNendo().toDateString();
            }
        }
        if (resultEntity != null && resultEntity.getUaft200entity() != null) {
            ShikibetsuCode 識別コードTemp = resultEntity.getUaft200entity().getShikibetsuCode();
            if (識別コードTemp != null) {
                this.住基情報_識別コード = 識別コードTemp.value();
            }
            KojinNo 個人番号Temp = resultEntity.getUaft200entity().getKojinNo();
            if (個人番号Temp != null) {
                this.住基情報_個人番号 = 個人番号Temp.value();
            }
            AtenaMeisho 漢字氏名Temp = resultEntity.getUaft200entity().getMeisho();
            if (漢字氏名Temp != null) {
                this.住基情報_漢字氏名 = 漢字氏名Temp.value();
            }
            AtenaKanaMeisho カナ氏名Temp = resultEntity.getUaft200entity().getKanaMeisho();
            if (カナ氏名Temp != null) {
                this.住基情報_カナ氏名 = カナ氏名Temp.value();
            }
            AtenaJusho 住基情報_漢字住所Temp = resultEntity.getUaft200entity().getJusho();
            if (住基情報_漢字住所Temp != null) {
                this.住基情報_漢字住所 = 住基情報_漢字住所Temp.value();
            }
            FlexibleDate 生年月日Temp = resultEntity.getUaft200entity().getSeinengappiYMD();
            if (生年月日Temp != null) {
                this.住基情報_生年月日 = DateConverter.flexibleDateToRDate(生年月日Temp);
            }
            this.住基情報_性別 = resultEntity.getUaft200entity().getSeibetsuCode();
            this.住基情報_住民種別 = resultEntity.getUaft200entity().getJuminShubetsuCode();
            this.住基情報_住登日 = resultEntity.getUaft200entity().getTorokuTodokedeYMD();
            this.住基情報_消除日 = resultEntity.getUaft200entity().getShojoTodokedeYMD();
            getEntityValue(resultEntity);
        }
    }

    private void getEntityValue(TokuchoTaishoshaIchiranSakuseiEntity resultEntity) {
        if (resultEntity != null && resultEntity.getDbt1001entity() != null) {
            HihokenshaNo 被保険者台帳_被保険者番号Temp = resultEntity.getDbt1001entity().getHihokenshaNo();
            if (被保険者台帳_被保険者番号Temp != null) {
                this.被保険者台帳_被保険者番号 = 被保険者台帳_被保険者番号Temp.value();
            }
            this.被保険者台帳_資格取得年月日 = resultEntity.getDbt1001entity().getShikakuShutokuYMD();
            this.被保険者台帳_資格取得事由 = resultEntity.getDbt1001entity().getShikakuShutokuJiyuCode();
            this.被保険者台帳_資格喪失年月日 = resultEntity.getDbt1001entity().getShikakuSoshitsuYMD();
            this.被保険者台帳_資格喪失事由 = resultEntity.getDbt1001entity().getShikakuSoshitsuJiyuCode();
        }
        if (resultEntity != null && resultEntity.getDbt2001entity() != null) {
            FlexibleYear 登録済年金情報_賦課年度Temp = resultEntity.getDbt2001entity().getFukaNendo();
            if (登録済年金情報_賦課年度Temp != null) {
                this.登録済年金情報_賦課年度 = 登録済年金情報_賦課年度Temp.wareki().toDateString();
            }
            this.登録済年金情報_仮徴収基礎年金番号 = resultEntity.getDbt2001entity().getKariNenkinNo();
            this.登録済年金情報_仮徴収年金コード = resultEntity.getDbt2001entity().getKariNenkinCode();
            this.登録済年金情報_仮徴収捕捉月 = resultEntity.getDbt2001entity().getKariHosokuM();
            this.登録済年金情報_本徴収基礎年金番号 = resultEntity.getDbt2001entity().getHonNenkinNo();
            this.登録済年金情報_本徴収年金コード = resultEntity.getDbt2001entity().getHonNenkinCode();
            this.登録済年金情報_本徴収捕捉月 = resultEntity.getDbt2001entity().getHonHosokuM();
            this.登録済年金情報_翌年度仮徴収基礎年金番号 = resultEntity.getDbt2001entity().getYokunendoKariNenkinNo();
            this.登録済年金情報_翌年度仮徴収年金コード = resultEntity.getDbt2001entity().getYokunendoKariNenkinCode();
            this.登録済年金情報_翌年度仮徴収捕捉月 = resultEntity.getDbt2001entity().getYokunendoKariHosokuM();
        }
    }
}
