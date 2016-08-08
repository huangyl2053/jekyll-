/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishokattokami;

import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC100065_負担割合証（カット紙）のEntityクラスです。
 *
 * @reamsid_L DBC-4990-061 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanWariaiShoEntity {

    private RString 交付年月日;
    private RString 被保険者番号;
    private RString 住所;
    private RString カナ氏名;
    private RString 氏名;
    private RString 生年月日;
    private RString 性別;
    private RString 負担割合１;
    private RString 適用開始年月日１;
    private RString 適用終了年月日１;
    private RString 負担割合２;
    private RString 適用開始年月日２;
    private RString 適用終了年月日２;
    private RString 保険者コード１;
    private RString 保険者コード２;
    private RString 保険者コード３;
    private RString 保険者コード４;
    private RString 保険者コード５;
    private RString 保険者コード６;
    private RString 保険者住所;
    private RString 保険者名;
    private RString 保険者電話番号;
    private RString 電子公印;
    private RString 連番;
    private RString OCR連番;
    private SofubutsuAtesakiSource 送付物宛先;

    public FutanWariaiShoEntity() {
    }

    /**
     *
     * @param 交付年月日 交付年月日
     * @param 被保険者番号 被保険者番号
     * @param 住所 住所
     * @param カナ氏名 カナ氏名
     * @param 氏名 氏名
     * @param 生年月日
     * @param 性別
     * @param 負担割合１
     * @param 適用開始年月日１
     * @param 適用終了年月日１
     * @param 負担割合２
     * @param 適用開始年月日２
     * @param 適用終了年月日２
     * @param 保険者コード１
     * @param 保険者コード２
     * @param 保険者コード３
     * @param 保険者コード４
     * @param 保険者コード５
     * @param 保険者コード６
     * @param 保険者住所
     * @param 保険者名
     * @param 保険者電話番号
     * @param 電子公印
     * @param 連番
     * @param OCR連番
     * @param 送付物宛先
     */
    public FutanWariaiShoEntity(RString 交付年月日, RString 被保険者番号, RString 住所, RString カナ氏名, RString 氏名,
            RString 生年月日, RString 性別, RString 負担割合１, RString 適用開始年月日１, RString 適用終了年月日１, RString 負担割合２,
            RString 適用開始年月日２, RString 適用終了年月日２, RString 保険者コード１, RString 保険者コード２, RString 保険者コード３,
            RString 保険者コード４, RString 保険者コード５, RString 保険者コード６, RString 保険者住所, RString 保険者名,
            RString 保険者電話番号, RString 電子公印, RString 連番, RString OCR連番, SofubutsuAtesakiSource 送付物宛先) {
        this.交付年月日 = 交付年月日;
        this.被保険者番号 = 被保険者番号;
        this.住所 = 住所;
        this.カナ氏名 = カナ氏名;
        this.氏名 = 氏名;
        this.生年月日 = 生年月日;
        this.性別 = 性別;
        this.負担割合１ = 負担割合１;
        this.適用開始年月日１ = 適用開始年月日１;
        this.適用終了年月日１ = 適用終了年月日１;
        this.負担割合２ = 負担割合２;
        this.適用開始年月日２ = 適用開始年月日２;
        this.適用終了年月日２ = 適用終了年月日２;
        this.保険者コード１ = 保険者コード１;
        this.保険者コード２ = 保険者コード２;
        this.保険者コード３ = 保険者コード３;
        this.保険者コード４ = 保険者コード４;
        this.保険者コード５ = 保険者コード５;
        this.保険者コード６ = 保険者コード６;
        this.保険者住所 = 保険者住所;
        this.保険者名 = 保険者名;
        this.保険者電話番号 = 保険者電話番号;
        this.電子公印 = 電子公印;
        this.連番 = 連番;
        this.OCR連番 = OCR連番;
        this.送付物宛先 = 送付物宛先;
    }

}
