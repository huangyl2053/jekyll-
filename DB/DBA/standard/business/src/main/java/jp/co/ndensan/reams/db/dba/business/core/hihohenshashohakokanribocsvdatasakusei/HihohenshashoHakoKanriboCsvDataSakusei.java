/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihohenshashohakokanribocsvdatasakusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 被保険者証発行管理簿_CSVデータ作成のクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihohenshashoHakoKanriboCsvDataSakusei {

    private final int 連番;
    private final HihokenshaNo 被保険者番号;
    private final RString 住民コード;
    private final YubinNo 郵便番号;
    private final RString 氏名;
    private final RString 住所;
    private final LasdecCode 市町村コードList;
    private final FlexibleDate 交付年月日;
    private final Code 交付事由コード;
    private final RString 交付事由略称;
    private final RString 交付事由名称;
    private final FlexibleDate 回収年月日;
    private final Code 回収事由コード;
    private final RString 回収事由名称;
    private final FlexibleDate 有効期限;
    private final RString 証様式区分コード;
    private final boolean 項目名付加フラグ;
    private final boolean 日付編集フラグ;

    /**
     * 非公開コンストラクタです。
     *
     * @param 連番 int
     * @param 被保険者番号 HihokenshaNo
     * @param 住民コード RString
     * @param 郵便番号 YubinNo
     * @param 氏名 RString
     * @param 住所 RString
     * @param 市町村コードList LasdecCode
     * @param 交付年月日 FlexibleDate
     * @param 交付事由コード Code
     * @param 交付事由略称 RString
     * @param 交付事由名称 RString
     * @param 回収年月日 FlexibleDate
     * @param 回収事由コード Code
     * @param 回収事由名称 RString
     * @param 有効期限 FlexibleDate
     * @param 証様式区分コード RString
     * @param 項目名付加フラグ boolean
     * @param 日付編集フラグ boolean
     */
    private HihohenshashoHakoKanriboCsvDataSakusei(
            int 連番,
            HihokenshaNo 被保険者番号,
            RString 住民コード,
            YubinNo 郵便番号,
            RString 氏名,
            RString 住所,
            LasdecCode 市町村コードList,
            FlexibleDate 交付年月日,
            Code 交付事由コード,
            RString 交付事由略称,
            RString 交付事由名称,
            FlexibleDate 回収年月日,
            Code 回収事由コード,
            RString 回収事由名称,
            FlexibleDate 有効期限,
            RString 証様式区分コード,
            boolean 項目名付加フラグ,
            boolean 日付編集フラグ) {
        this.連番 = 連番;
        this.被保険者番号 = 被保険者番号;
        this.住民コード = 住民コード;
        this.郵便番号 = 郵便番号;
        this.氏名 = 氏名;
        this.住所 = 住所;
        this.市町村コードList = 市町村コードList;
        this.交付年月日 = 交付年月日;
        this.交付事由コード = 交付事由コード;
        this.交付事由略称 = 交付事由略称;
        this.交付事由名称 = 交付事由名称;
        this.回収年月日 = 回収年月日;
        this.回収事由コード = 回収事由コード;
        this.回収事由名称 = 回収事由名称;
        this.有効期限 = 有効期限;
        this.証様式区分コード = 証様式区分コード;
        this.項目名付加フラグ = 項目名付加フラグ;
        this.日付編集フラグ = 日付編集フラグ;
    }

    /**
     * 証発行管理CSVデータリスト作成を生成します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 住民コード RString
     * @param 郵便番号 YubinNo
     * @param 氏名 RString
     * @param 住所 RString
     * @param 市町村コードList LasdecCode
     * @param 交付年月日 FlexibleDate
     * @param 交付事由コード Code
     * @param 交付事由略称 RString
     * @param 交付事由名称 RString
     * @param 回収年月日 FlexibleDate
     * @param 回収事由コード Code
     * @param 回収事由名称 RString
     * @param 有効期限 FlexibleDate
     * @param 証様式区分コード RString
     * @param 項目名付加フラグ boolean
     * @param 日付編集フラグ boolean
     * @return バッチ用のパラメータです
     */
    public static HihohenshashoHakoKanriboCsvDataSakusei createParam_ShohakkoKanriCSVDataList(
            HihokenshaNo 被保険者番号,
            RString 住民コード,
            YubinNo 郵便番号,
            RString 氏名,
            RString 住所,
            LasdecCode 市町村コードList,
            FlexibleDate 交付年月日,
            Code 交付事由コード,
            RString 交付事由略称,
            RString 交付事由名称,
            FlexibleDate 回収年月日,
            Code 回収事由コード,
            RString 回収事由名称,
            FlexibleDate 有効期限,
            RString 証様式区分コード,
            boolean 項目名付加フラグ,
            boolean 日付編集フラグ) {
        return new HihohenshashoHakoKanriboCsvDataSakusei(
                0,
                被保険者番号,
                住民コード,
                郵便番号,
                氏名,
                住所,
                市町村コードList,
                交付年月日,
                交付事由コード,
                交付事由略称,
                交付事由名称,
                回収年月日,
                回収事由コード,
                回収事由名称,
                有効期限,
                証様式区分コード,
                項目名付加フラグ,
                日付編集フラグ
        );
    }

    /**
     * 証発行管理CSVデータリスト作成 (連番有)を生成します。
     *
     * @param 連番 int
     * @param 被保険者番号 HihokenshaNo
     * @param 住民コード RString
     * @param 郵便番号 YubinNo
     * @param 氏名 RString
     * @param 住所 RString
     * @param 市町村コードList LasdecCode
     * @param 交付年月日 FlexibleDate
     * @param 交付事由コード Code
     * @param 交付事由略称 RString
     * @param 交付事由名称 RString
     * @param 回収年月日 FlexibleDate
     * @param 回収事由コード Code
     * @param 回収事由名称 RString
     * @param 有効期限 FlexibleDate
     * @param 証様式区分コード RString
     * @param 項目名付加フラグ boolean
     * @param 日付編集フラグ boolean
     * @return バッチ用のパラメータです
     */
    public static HihohenshashoHakoKanriboCsvDataSakusei createParam_ShohakkoKanriCSVDataListAddRenban(
            int 連番,
            HihokenshaNo 被保険者番号,
            RString 住民コード,
            YubinNo 郵便番号,
            RString 氏名,
            RString 住所,
            LasdecCode 市町村コードList,
            FlexibleDate 交付年月日,
            Code 交付事由コード,
            RString 交付事由略称,
            RString 交付事由名称,
            FlexibleDate 回収年月日,
            Code 回収事由コード,
            RString 回収事由名称,
            FlexibleDate 有効期限,
            RString 証様式区分コード,
            boolean 項目名付加フラグ,
            boolean 日付編集フラグ) {
        return new HihohenshashoHakoKanriboCsvDataSakusei(
                連番,
                被保険者番号,
                住民コード,
                郵便番号,
                氏名,
                住所,
                市町村コードList,
                交付年月日,
                交付事由コード,
                交付事由略称,
                交付事由名称,
                回収年月日,
                回収事由コード,
                回収事由名称,
                有効期限,
                証様式区分コード,
                項目名付加フラグ,
                日付編集フラグ
        );
    }
}
