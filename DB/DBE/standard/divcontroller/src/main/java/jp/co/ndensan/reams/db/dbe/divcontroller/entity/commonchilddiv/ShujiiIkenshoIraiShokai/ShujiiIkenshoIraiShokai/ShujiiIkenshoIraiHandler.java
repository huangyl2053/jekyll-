/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoIraiShokai.ShujiiIkenshoIraiShokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoirai.ShujiiIkenshoIraiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshoiraishokai.ShujiiIkenshoIraiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 *
 * 主治医意見書作成依頼情報のHandlerクラスです。
 */
public class ShujiiIkenshoIraiHandler {

    private final ShujiiIkenshoIraiShokaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShujiiIkenshoIraiShokaiDiv
     */
    public ShujiiIkenshoIraiHandler(ShujiiIkenshoIraiShokaiDiv div) {
        this.div = div;
    }

    /**
     * 主治医意見書作成依頼情報を設定します。
     *
     * @param hihokenshano 被保険者番号
     */
    public void initialize(HihokenshaNo hihokenshano) {
        div.getCcdKaigoShikakuKihon().initialize(hihokenshano);
        ShujiiIkenshoIraiShokaiFinder finder = ShujiiIkenshoIraiShokaiFinder.createInstance();
        List<ShujiiIkenshoIraiBusiness> 認定調査情報 = finder.getNinnteiChousa(hihokenshano).records();
        init(認定調査情報);
    }

    private void init(List<ShujiiIkenshoIraiBusiness> 認定調査情報) {
        List<dgIkenshoIraiIchiran_Row> dataRowList = new ArrayList<>();
        Integer index = 1;
        for (ShujiiIkenshoIraiBusiness shujiiikenshoirai : 認定調査情報) {
            dgIkenshoIraiIchiran_Row row = new dgIkenshoIraiIchiran_Row();
            row.setNumber(new RString(index.toString()));
            row.getNinyeiShonseibi().setValue(new RDate(shujiiikenshoirai.getNinteiShinseiYMD().toString()));
            row.setShinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode.toValue(new RString(shujiiikenshoirai
                    .getNinteiShinseiCode().toString())).toRString());
            row.getNiteiTorisageDay().setValue(new RDate(shujiiikenshoirai.getTorisageYMD().toString()));
            row.getNinteibi().setValue(new RDate(shujiiikenshoirai.getNijiHanteiYMD().toString()));
            row.setYokaigodo(YokaigoJotaiKubun09.toValue(new RString(shujiiikenshoirai.getNijiHanteiYokaigoJotaiCode().toString())).get名称());
            RStringBuilder nijiHantei = new RStringBuilder();
            nijiHantei.append(shujiiikenshoirai.getNijiHanteiNinteiYukoKikan());
            nijiHantei.append(new RString("ヶ月"));
            row.setYukoKikan(nijiHantei.toRString());
            row.setIryoKikanNumber(shujiiikenshoirai.getShujiiIryokikanCode());
            row.setIryoKikanMeisho(shujiiikenshoirai.getIryoKikanMeisho());
            row.setShujiiCode(shujiiikenshoirai.getShujiiCode());
            row.setShujiiMeisho(new RString(shujiiikenshoirai.getShujiiName().toString()));
            row.getIkenshoTorikomiDay().setValue(new RDate(shujiiikenshoirai.getIkenshoJuryoYMD().toString()));
            row.getIkenshoKinyuDay().setValue(new RDate(shujiiikenshoirai.getIkenshoKinyuYMD().toString()));
            row.setIraiKubun(new RString(IkenshoIraiKubun.toValue(new RString(shujiiikenshoirai.getIkenshoIraiKubun().toString())).name()));
            dataRowList.add(row);
            index = index + 1;
        }
        div.getDgIkenshoIraiIchiran().setDataSource(dataRowList);
        div.getBtnModoru().setDisabled(false);
    }
}
