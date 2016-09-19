/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.shorikekkakakuninlist.ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.shorikekkakakuninlist.ShoriKekkaKakuninListReportSource;

/**
 * 処理確認リストのヘーダEditorです。
 *
 * @reamsid_L DBU-5590-040 wanghuafeng
 */
public class ShoriKekkaKakuninListEditor implements IShoriKekkaKakuninListEditor {

    private final ShoriKekkaKakuninListEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link ShoriKekkaKakuninListEntity}
     */
    protected ShoriKekkaKakuninListEditor(ShoriKekkaKakuninListEntity entity) {
        this.entity = entity;
    }

    /**
     * 処理確認リストのヘーダのedit
     *
     * @param source ShoriKekkaKakuninListReportSource
     * @return ShoriKekkaKakuninListReportSource
     */
    @Override
    public ShoriKekkaKakuninListReportSource edit(ShoriKekkaKakuninListReportSource source) {
        return editHeader(source);
    }

    private ShoriKekkaKakuninListReportSource editHeader(ShoriKekkaKakuninListReportSource source) {
        source.printTimeStamp = entity.get作成日時();
        source.shichosonCode = entity.get保険者番号();
        source.shichosonName = entity.get保険者名();
        source.keyKomoku1 = entity.get項目コード1();
        source.keyKomoku2 = entity.get項目コード2();
        source.keyKomoku3 = entity.get項目コード3();
        source.keyKomoku4 = entity.get項目コード4();
        source.listUpper_1 = entity.getプログラムID();
        source.listUpper_2 = entity.get項目値1();
        source.listUpper_3 = entity.get項目値2();
        source.listUpper_4 = entity.get項目値3();
        source.listUpper_5 = entity.get項目値4();
        source.listUpper_7 = entity.get内容1();
        source.listLower_1 = entity.get処理名称();
        source.listLower_2 = entity.get内容2();
        return source;
    }

}
