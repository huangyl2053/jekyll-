/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomiiraisho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.furikaego.FurikaeGoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomiiraisho.FurikomiIraishoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC100059_事業合算・事業分振込明細書作成（一括） BodyEditorクラスです
 *
 * @reamsid_L DBC-4870-040 lijian
 */
public class FurikomiIraishoBodyEditor implements IFurikomiIraishoEditor {

    private static final RString 定数銀行計 = new RString("銀行計");
    private static final RString 定数口 = new RString("口");
    private static final RString 定数円 = new RString("円");
    private static final RString 定数支店計 = new RString("支店計");
    private final FurikaeGoEntity 振込Entity;

    /**
     * コンストラクタです。
     *
     * @param 振込Entity FurikaeGoEntity
     */
    public FurikomiIraishoBodyEditor(FurikaeGoEntity 振込Entity) {
        this.振込Entity = 振込Entity;
    }

    @Override
    public FurikomiIraishoSource edit(FurikomiIraishoSource source) {

        if (振込Entity.get金融機関コード() != null) {
            source.List1_1 = 振込Entity.get金融機関コード().value();
        }
        source.List1_2 = 振込Entity.get預金種目コード();
        source.List1_3 = 振込Entity.get受取人カナ();
        source.List1_4 = 振込Entity.get摘要();

        source.List2_1 = 振込Entity.get金融機関名();
        source.List2_2 = 振込Entity.get預金種目();
        source.List2_3 = 振込Entity.get口座番号();
        source.List2_4 = 振込Entity.get受取人氏名();
        if (振込Entity.get被保険者番号() != null) {
            source.List2_5 = 振込Entity.get被保険者番号().value();
        }
        if (振込Entity.get金額() != null) {
            source.List2_6 = new RString(振込Entity.get金額().toString());
        }
        source.List2_7 = 振込Entity.get摘要2();

        source.ginko_kei_ft = 定数銀行計;
        source.kuchi_1 = 定数口;
        source.yen_1 = 定数円;
        source.kuchi_2 = 定数口;
        source.yen_2 = 定数円;
        if (振込Entity.get銀行計口数() != null) {
            source.ginko_kuchisu = new RString(振込Entity.get銀行計口数().toString());
        }
        if (振込Entity.get銀行計金額() != null) {
            source.ginko_kingaku = new RString(振込Entity.get銀行計金額().toString());
        }
        source.shiten_kei_ft = 定数支店計;
        if (振込Entity.get支店計口数() != null) {
            source.shiten_kuchisu = new RString(振込Entity.get支店計口数().toString());
        }
        if (振込Entity.get支店計金額() != null) {
            source.shiten_kingaku = new RString(振込Entity.get支店計金額().toString());
        }
        if (振込Entity.get頁計口数() != null) {
            source.shokei_kuchisu = new RString(振込Entity.get頁計口数().toString());
        }
        if (振込Entity.get頁計金額() != null) {
            source.shokei_kingaku = new RString(振込Entity.get頁計金額().toString());
        }

        return source;
    }

}
