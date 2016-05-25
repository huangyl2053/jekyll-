package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaichohakkoichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaichohakkoichiranhyo.HihokenshaDaichoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 被保険者台帳一覧表エディターのインターフェースクラスです。
 *
 * @reamsid_L DBA-0510-070 wangxiaodong
 */
public class HihokenshaDaichoHakkoIchiranhyoBodyEditor implements IHihokenshaDaichoHakkoIchiranhyoEditor {

    private final HihokenshaDaichoHakkoIchiranhyoBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 被保険者台帳一覧表ボディーItem
     */
    public HihokenshaDaichoHakkoIchiranhyoBodyEditor(HihokenshaDaichoHakkoIchiranhyoBodyItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public HihokenshaDaichoHakkoIchiranhyoReportSource edit(HihokenshaDaichoHakkoIchiranhyoReportSource source) {

        return editBody(source);
    }

    private HihokenshaDaichoHakkoIchiranhyoReportSource editBody(HihokenshaDaichoHakkoIchiranhyoReportSource source) {

        source.shikibetuCode = new ShikibetsuCode(bodyItem.getListUpper_6());
        source.hishokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), bodyItem.getListNo_1());
        source.listNo_1 = bodyItem.getListNo_1();
        source.listUpper_1 = bodyItem.getListUpper_1();
        source.listUpper_2 = bodyItem.getListUpper_2();
        source.listUpper_3 = bodyItem.getListUpper_3();
        source.listUpper_4 = bodyItem.getListUpper_4();
        source.listUpper_5 = bodyItem.getListUpper_5();
        source.listUpper_6 = bodyItem.getListUpper_6();
        source.listUpper_7 = bodyItem.getListUpper_7();
        source.listUpper_8 = bodyItem.getListUpper_8();
        source.listBiko_1 = bodyItem.getListBiko_1();
        source.listLower_1 = bodyItem.getListLower_1();
        source.listLower_2 = bodyItem.getListLower_2();
        source.listLower_3 = bodyItem.getListLower_3();
        source.listLower_4 = bodyItem.getListLower_4();
        source.listLower_5 = bodyItem.getListLower_5();
        source.listLower_6 = bodyItem.getListLower_6();

        return source;
    }
}
