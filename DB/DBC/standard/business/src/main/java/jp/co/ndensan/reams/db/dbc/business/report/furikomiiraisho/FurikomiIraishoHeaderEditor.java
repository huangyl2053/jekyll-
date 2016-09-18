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
 * 帳票設計_DBC100059_事業合算・事業分振込明細書作成（一括） HeaderEditorクラスです
 *
 * @reamsid_L DBC-4870-040 lijian
 */
public class FurikomiIraishoHeaderEditor implements IFurikomiIraishoEditor {

    private final FurikaeGoEntity 振込Entity;

    /**
     * コンストラクタです。
     *
     * @param 振込Entity FurikaeGoEntity
     */
    public FurikomiIraishoHeaderEditor(FurikaeGoEntity 振込Entity) {
        this.振込Entity = 振込Entity;
    }

    @Override
    public FurikomiIraishoSource edit(FurikomiIraishoSource source) {
        source.title = 振込Entity.get帳票タイトル();
        if (振込Entity.get依頼日() != null) {
            source.Irai_YMD = new RString(振込Entity.get依頼日().toString());
        }
        if (振込Entity.get振込指定日() != null) {
            source.Furikomi_YMD = new RString(振込Entity.get振込指定日().toString());
        }
        source.so_page = new RString(振込Entity.get枚中());
        source.page = 振込Entity.get枚目();
        source.irai_mongon1 = 振込Entity.get依頼文言１();
        source.irai_mongon2 = 振込Entity.get依頼文言２();
        source.irainin_1 = 振込Entity.get依頼人1();
        source.irainin_2 = 振込Entity.get依頼人2();
        source.sama = 振込Entity.get様();
        if (振込Entity.get振込口数() != null) {
            source.furikomi_kuchisu = new RString(振込Entity.get振込口数().toString());
        }
        if (振込Entity.get振込金額() != null) {
            source.furikomi_kingaku = new RString(振込Entity.get振込金額().toString());
        }
        source.tsuchi_mongon = 振込Entity.get通知文言();
        source.shitei_kinyu_mei_1 = 振込Entity.get指定金融機関名称1();
        source.shitei_kinyu_mei_2 = 振込Entity.get指定金融機関名称2();
        source.onchu_in = 振込Entity.get御中();
        return source;
    }

}
