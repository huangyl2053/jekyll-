/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoIraiShokai.ShujiiIkenshoIraiShokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoirai.ShujiiIkenshoIraiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshoiraishokai.ShujiiIkenshoIraiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 主治医意見書作成依頼情報のHandlerクラスです。
 *
 * @reamsid_L DBE-0200-030 zhangzhiming
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
     */
    public void initialize() {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        ShujiiIkenshoIraiShokaiFinder finder = ShujiiIkenshoIraiShokaiFinder.createInstance();
        List<ShujiiIkenshoIraiBusiness> 認定調査情報 = finder.getNinnteiChousa(申請書管理番号).records();
        init(認定調査情報);
    }

    private void init(List<ShujiiIkenshoIraiBusiness> 認定調査情報) {
        List<dgIkenshoIraiIchiran_Row> dataRowList = new ArrayList<>();
        Integer index = 1;
        for (ShujiiIkenshoIraiBusiness shujiiikenshoirai : 認定調査情報) {
            dgIkenshoIraiIchiran_Row row = new dgIkenshoIraiIchiran_Row();
            row.setNumber(new RString(index.toString()));
            if (shujiiikenshoirai.getNinteiShinseiYMD() != null) {
                row.getNinyeiShonseibi().setValue(new RDate(shujiiikenshoirai.getNinteiShinseiYMD().toString()));
            }
            if (shujiiikenshoirai.getNinteiShinseiCode() != null) {
                row.setShinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode.toValue(new RString(shujiiikenshoirai
                        .getNinteiShinseiCode().toString())).get名称());
            }
            if (shujiiikenshoirai.getTorisageYMD() != null && !shujiiikenshoirai.getTorisageYMD().isEmpty()) {
                row.getNiteiTorisageDay().setValue(new RDate(shujiiikenshoirai.getTorisageYMD().toString()));
            }
            if (shujiiikenshoirai.getNijiHanteiYMD() != null && !shujiiikenshoirai.getNijiHanteiYMD().isEmpty()) {
                row.getNinteibi().setValue(new RDate(shujiiikenshoirai.getNijiHanteiYMD().toString()));
            }
            if (shujiiikenshoirai.getNijiHanteiYokaigoJotaiCode() != null && !shujiiikenshoirai.getNijiHanteiYokaigoJotaiCode().isEmpty()) {
                if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(shujiiikenshoirai.getKoroshoIfShikibetsuCode().value())) {
                    row.setYokaigodo(YokaigoJotaiKubun99.toValue(new RString(shujiiikenshoirai.getNijiHanteiYokaigoJotaiCode().toString())).get名称());
                } else if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(shujiiikenshoirai.getKoroshoIfShikibetsuCode().value())) {
                    row.setYokaigodo(YokaigoJotaiKubun02.toValue(new RString(shujiiikenshoirai.getNijiHanteiYokaigoJotaiCode().toString())).get名称());
                } else if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(shujiiikenshoirai.getKoroshoIfShikibetsuCode().value())) {
                    row.setYokaigodo(YokaigoJotaiKubun06.toValue(new RString(shujiiikenshoirai.getNijiHanteiYokaigoJotaiCode().toString())).get名称());
                } else {
                    row.setYokaigodo(YokaigoJotaiKubun09.toValue(new RString(shujiiikenshoirai.getNijiHanteiYokaigoJotaiCode().toString())).get名称());
                }
            }
            RStringBuilder nijiHantei = new RStringBuilder();
            nijiHantei.append(shujiiikenshoirai.getNijiHanteiNinteiYukoKikan());
            nijiHantei.append(new RString("ヶ月"));
            row.setYukoKikan(nijiHantei.toRString());
            row.setIryoKikanNumber(shujiiikenshoirai.getShujiiIryokikanCode());
            row.setIryoKikanMeisho(shujiiikenshoirai.getIryoKikanMeisho());
            row.setShujiiCode(shujiiikenshoirai.getShujiiCode());
            if (shujiiikenshoirai.getShujiiName() != null && !shujiiikenshoirai.getShujiiName().isEmpty()) {
                row.setShujiiMeisho(new RString(shujiiikenshoirai.getShujiiName().toString()));
            }
            if (shujiiikenshoirai.getIkenshoJuryoYMD() != null && !shujiiikenshoirai.getIkenshoJuryoYMD().isEmpty()) {
                row.getIkenshoTorikomiDay().setValue(new RDate(shujiiikenshoirai.getIkenshoJuryoYMD().toString()));
            }
            if (shujiiikenshoirai.getIkenshoKinyuYMD() != null && !shujiiikenshoirai.getIkenshoKinyuYMD().isEmpty()) {
                row.getIkenshoKinyuDay().setValue(new RDate(shujiiikenshoirai.getIkenshoKinyuYMD().toString()));
            }
            if (shujiiikenshoirai.getIkenshoIraiKubun() != null && !shujiiikenshoirai.getIkenshoIraiKubun().isEmpty()) {
                row.setIraiKubun(new RString(IkenshoIraiKubun.toValue(new RString(shujiiikenshoirai.getIkenshoIraiKubun().toString())).name()));
            }
            dataRowList.add(row);
            index = index + 1;
        }
        div.getDgIkenshoIraiIchiran().setDataSource(dataRowList);
        div.getBtnReturn().setDisabled(false);
    }
}
