/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoIraiShokai.ShujiiIkenshoIraiShokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoirai.ShujiiIkenshoIraiBusiness;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshoiraishokai.ShujiiIkenshoIraiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

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
        HihokenshaNo hihokenshano = new HihokenshaNo(div.getHihokenshano());
        RString 証記載保険者番号 = RString.EMPTY;
        RString 市町村コード = RString.EMPTY;
        ShichosonSecurityJohoFinder 市町村セキュリティFinder = InstanceProvider.create(ShichosonSecurityJohoFinder.class);
        ShichosonSecurityJoho 市町村セキュリティ情報 = 市町村セキュリティFinder.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        if (市町村セキュリティ情報 != null) {
            if (!市町村セキュリティ情報.get市町村情報().get市町村識別ID().equals(new ShichosonShikibetsuID("00"))) {
                市町村コード = 市町村セキュリティ情報.get市町村情報().get市町村コード().value();
            }
            証記載保険者番号 = 市町村セキュリティ情報.get市町村情報().get証記載保険者番号().value();
        }
//        div.getCcdKaigoShikakuKihon().onLoad(hihokenshano);
        ShujiiIkenshoIraiShokaiFinder finder = ShujiiIkenshoIraiShokaiFinder.createInstance();
        List<ShujiiIkenshoIraiBusiness> 認定調査情報 = finder.getNinnteiChousa(hihokenshano).records();
        if (認定調査情報 != null && !RString.isNullOrEmpty(証記載保険者番号)) {
            List<ShujiiIkenshoIraiBusiness> ninteiChosaListCopy = new ArrayList<>(認定調査情報);
            認定調査情報 = get対象証記載保険者認定調査List(ninteiChosaListCopy, 証記載保険者番号);
            if (!RString.isNullOrEmpty(市町村コード)) {
                List<ShujiiIkenshoIraiBusiness> ninteiChosaListCopy2 = new ArrayList<>(認定調査情報);
                認定調査情報 = get対象市町村認定調査List(ninteiChosaListCopy2, 市町村コード);
            }
        }
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
                row.setYokaigodo(YokaigoJotaiKubun09.toValue(new RString(shujiiikenshoirai.getNijiHanteiYokaigoJotaiCode().toString())).get名称());
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
    
    private List<ShujiiIkenshoIraiBusiness> get対象証記載保険者認定調査List(List<ShujiiIkenshoIraiBusiness> 認定調査List, RString 証記載保険者番号) {
        List<ShujiiIkenshoIraiBusiness> 対象認定調査List = new ArrayList<>();
        for (ShujiiIkenshoIraiBusiness 認定調査Entity : 認定調査List) {
            if (証記載保険者番号.equals(認定調査Entity.getShoKisaiHokenshaNo())) {
                対象認定調査List.add(認定調査Entity);
            }
        }
        return 対象認定調査List;
    }
    
    private List<ShujiiIkenshoIraiBusiness> get対象市町村認定調査List(List<ShujiiIkenshoIraiBusiness> 認定調査List, RString 市町村コード) {
        List<ShujiiIkenshoIraiBusiness> 対象認定調査List = new ArrayList<>();
        for (ShujiiIkenshoIraiBusiness 認定調査Entity : 認定調査List) {
            if (市町村コード.substring(0, 5).equals(認定調査Entity.getShinseishoKanriNo().value().substring(0, 5))) {
                対象認定調査List.add(認定調査Entity);
            }
        }
        return 対象認定調査List;
    }
}
