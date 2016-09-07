/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyosakusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ファイル出力（所得情報一覧表）のクラスです。
 *
 * @reamsid_L DBB-1650-050 lijunjun
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenShotokuCSVEntity {

    @CsvField(order = 10, name = "識別コード")
    private ShikibetsuCode 識別コード;
    @CsvField(order = 20, name = "氏名カナ")
    private AtenaKanaMeisho 氏名カナ;
    @CsvField(order = 30, name = "所得年度")
    private FlexibleYear 所得年度;
    @CsvField(order = 40, name = "生年月日")
    private FlexibleDate 生年月日;
    @CsvField(order = 50, name = "性別")
    private RString 性別;
    @CsvField(order = 60, name = "住民税課税区分減免前")
    private RString 住民税課税区分減免前;
    @CsvField(order = 70, name = "住民税課税区分減免後")
    private RString 住民税課税区分減免後;
    @CsvField(order = 80, name = "住民税")
    private RString 住民税;
    @CsvField(order = 90, name = "合計所得金額")
    private Decimal 合計所得金額;
    @CsvField(order = 100, name = "課税標準額")
    private Decimal 課税標準額;
    @CsvField(order = 110, name = "登録業務")
    private RString 登録業務;
    @CsvField(order = 120, name = "被保険者番号")
    private HihokenshaNo 被保険者番号;
    @CsvField(order = 130, name = "氏名")
    private AtenaMeisho 氏名;
    @CsvField(order = 140, name = "年齢")
    private int 年齢;
    @CsvField(order = 150, name = "種別")
    private RString 種別;
    @CsvField(order = 160, name = "年金収入額")
    private Decimal 年金収入額;
    @CsvField(order = 170, name = "年金所得額")
    private Decimal 年金所得額;

    /**
     * コンストラクタです。
     *
     * @param 識別コード ShikibetsuCode
     * @param 氏名カナ AtenaKanaMeisho
     * @param 所得年度 FlexibleYear
     * @param 生年月日 FlexibleDate
     * @param 性別 RString
     * @param 住民税課税区分減免前 RString
     * @param 住民税課税区分減免後 RString
     * @param 住民税 RString
     * @param 合計所得金額 Decimal
     * @param 課税標準額 Decimal
     * @param 登録業務 RString
     * @param 被保険者番号 HihokenshaNo
     * @param 氏名 AtenaMeisho
     * @param 年齢 int
     * @param 種別 RString
     * @param 年金収入額 Decimal
     * @param 年金所得額 Decimal
     */
    public KaigoHokenShotokuCSVEntity(ShikibetsuCode 識別コード,
            AtenaKanaMeisho 氏名カナ,
            FlexibleYear 所得年度,
            FlexibleDate 生年月日,
            RString 性別,
            RString 住民税課税区分減免前,
            RString 住民税課税区分減免後,
            RString 住民税,
            Decimal 合計所得金額,
            Decimal 課税標準額,
            RString 登録業務,
            HihokenshaNo 被保険者番号,
            AtenaMeisho 氏名,
            int 年齢,
            RString 種別,
            Decimal 年金収入額,
            Decimal 年金所得額) {
        this.識別コード = 識別コード;
        this.氏名カナ = 氏名カナ;
        this.所得年度 = 所得年度;
        this.生年月日 = 生年月日;
        this.性別 = 性別;
        this.住民税課税区分減免前 = 住民税課税区分減免前;
        this.住民税課税区分減免後 = 住民税課税区分減免後;
        this.住民税 = 住民税;
        this.合計所得金額 = 合計所得金額;
        this.課税標準額 = 課税標準額;
        this.登録業務 = 登録業務;
        this.被保険者番号 = 被保険者番号;
        this.氏名 = 氏名;
        this.年齢 = 年齢;
        this.種別 = 種別;
        this.年金収入額 = 年金収入額;
        this.年金所得額 = 年金所得額;
    }
}
