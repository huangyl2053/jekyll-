/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.chosaitakusakiandchosaininput;

import jp.co.ndensan.reams.db.dbd.business.HokenshaChosainJoho;
import jp.co.ndensan.reams.db.dbd.business.HokenshaNinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbd.business.IChosainJoho;
import jp.co.ndensan.reams.db.dbd.business.INinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbd.business.INinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbd.business.IShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbd.business.ShinsakaiChosainJoho;
import jp.co.ndensan.reams.db.dbd.business.ShinsakaiNinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbd.realservice.ChosaItakusakiFactory;
import jp.co.ndensan.reams.db.dbd.realservice.ChosainFactory;
import jp.co.ndensan.reams.db.dbd.realservice.IChosaItakusakiManager;
import jp.co.ndensan.reams.db.dbd.realservice.IChosainManager;
import jp.co.ndensan.reams.db.dbd.realservice.INinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbd.realservice.IShinseiRirekiManager;
import jp.co.ndensan.reams.db.dbd.realservice.NinteiShinseiJohoManagerFactory;
import jp.co.ndensan.reams.db.dbd.realservice.ShinseiRirekiFactory;
import jp.co.ndensan.reams.db.dbz.business.koseishichosonmaster.IKoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.realservice.koseishichosonmaster.IKoseiShichosonMasterManager;
import jp.co.ndensan.reams.db.dbz.realservice.koseishichosonmaster.KoseiShichosonMasterFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査委託先/調査員入力共有子Divのエンティティに対する操作を行うクラスです。
 *
 * @author n8223　朴義一
 */
public class ChosaItakusakiAndChosainInputHandler {

    private final ChosaItakusakiAndChosainInputDiv div;
    private IShinseiRirekiManager shinseiRirekiManager;
    private INinteiShinseiJohoManager ninteiShinseiJohoManager;
    private IKoseiShichosonMasterManager koseiShichosonMasterManager;
    private IChosaItakusakiManager chosaItakusakimanager;
    private IChosainManager chosaInmanager;

    private final SubGyomuCode subGyomuCode;

    /**
     * コンストラクタです。
     *
     * @param chosaItakusakiAndChosainInputDiv 調査委託先/調査員入力共有子のエンティティ
     */
    public ChosaItakusakiAndChosainInputHandler(ChosaItakusakiAndChosainInputDiv chosaItakusakiAndChosainInputDiv) {
        this.div = chosaItakusakiAndChosainInputDiv;
        this.subGyomuCode = new SubGyomuCode(div.getHdnDatabaseSubGyomuCode());
    }

    /**
     * (認定調査委託先コード）引数から受け取った認定調査委託先情報を取得します。
     */
    public void onBlurTxtChosaItakusakiCode() {
        //受渡しにフォームのhiddenの申請書管理番号と画面で入力値の認定調査委託コートをもとに
        //①証記載保険者番号と構成市町村マスタDBでの証記載保険者番号と比較して、市町村コードを取得します。
        //②その市町村コードと画面で入力値の認定調査委託コートをもとに認定調査委託先情報DBの市町村コード・認定調査委託コートを比較してから
        //認定調査委託先情報を取得します。
        IChosaItakusakiManager chosaItakusakimanager = ChosaItakusakiFactory.getInstance(new SubGyomuCode(div.getHdnDatabaseSubGyomuCode()));
        Optional<INinteichosaItakusakiJoho> chosaItakusakiJoho = chosaItakusakimanager.find調査委託先情報(new LasdecCode(div.getHdnShichosonCode()),
                new ChosaItakusakiCode(div.getTxtChosaItakusakiCode().getValue()));
        //調査委託先名を画面に設定します。
        if (chosaItakusakiJoho.isPresent()) {
            div.getTxtChosaItakusakiName().setValue(chosaItakusakiJoho.get().get事業者名称());
        } else {
            div.getTxtChosaItakusakiName().clearValue();
        }
    }

    /**
     * (調査員コード）引数から受け取った調査員情報を取得します。
     */
    public void onBlurTxtChosainCode() {
        //受渡しにフォームのhiddenの申請書管理番号と画面で入力値の調査員コードをもとに
        //①証記載保険者番号と構成市町村マスタDBでの証記載保険者番号と比較して、市町村コードを取得します。
        //②その市町村コードと②画面で入力値の認定調査委託コートと画面で入力値の調査員コードをもとに認定員情報DBの市町村コード・
        //認定調査委託コート・認定調査委託コートを比較してから認定調査員情報を取得します。
        IChosainManager chosaInmanager = ChosainFactory.getInstance(new SubGyomuCode(div.getHdnDatabaseSubGyomuCode()));
        Optional<IChosainJoho> chosainJoho
                = chosaInmanager.find調査員情報(new LasdecCode(div.getHdnShichosonCode()),
                        new ChosaItakusakiCode(div.getTxtChosaItakusakiCode().getValue()),
                        new ChosainCode(div.getTxtChosainCode().getValue()));
        //調査員名を画面に設定します。
        if (chosainJoho.isPresent()) {
            div.getTxtChosainName().setValue(chosainJoho.get().get調査員氏名());
        } else {
            div.getTxtChosainName().clearValue();
        }

    }

    /**
     * 前回申請管理情報を取得します。
     */
    public void onClickBtnZenkaiFukusha() {

        //①受渡しにフォームのhiddenの申請書管理番号と履歴申請情報で、前回申請管理番号があれば、②-1
        createZenkaiJohoManager();
        Optional<IShinseiRirekiJoho> shinseiRirekiJoho = shinseiRirekiManager.find申請履歴情報(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()));
        if (shinseiRirekiJoho.isPresent()) {
            createZenkaiJoho(shinseiRirekiJoho);
        } else {
            //①受渡しにフォームのhiddenの申請書管理番号と履歴申請情報で、前回申請管理番号があれば、②-2
            //②－2
            onClickBtnClear();
        }
    }

    private void createZenkaiJoho(Optional<IShinseiRirekiJoho> shinseiRirekiJoho) {
        //②－1
        //履歴申請情報から前回申請管理番号をもとに、③介護認定申請情報から申請書管理番号を比較して認定調査委託コード・認定調査委託員コード・証記載保険者番号を取得します。
        //その証記載保険者番号と④構成市町村マスタの保険者番号と比較して市町村コードを取得します。
        Optional<INinteiShinseiJoho> ninteiShinseiJoho
                = ninteiShinseiJohoManager.find認定申請情報(shinseiRirekiJoho.get().get前回申請管理番号());
        Optional<IKoseiShichosonMaster> koseiShichosonMaster
                = koseiShichosonMasterManager.find構成市町村(new ShoKisaiHokenshaNo(ninteiShinseiJoho.get().get証記載保険者番号()));
        //⑤-1③から取得した認定調査委託コード・④から取得した市町村コードをもとに認定調査委託先情報の認定調査委託コード・市町村コードと比較してから認定調査委託先情報を取得します。
        Optional<INinteichosaItakusakiJoho> chosaItakusakiJoho
                = chosaItakusakimanager.find調査委託先情報(koseiShichosonMaster.get().get市町村コード(), ninteiShinseiJoho.get().get認定調査委託先コード());
        //⑤-2③から取得した認定調査委託コード・認定調査委託員コード・④から取得した市町村コードをもとに調査員情報の認定調査委託コード・認定調査委託員コード・市町村コードと比較して
        //取得します。
        Optional<IChosainJoho> chosainJoho
                = chosaInmanager.find調査員情報(koseiShichosonMaster.get().get市町村コード(), ninteiShinseiJoho.get().get認定調査委託先コード(),
                        ninteiShinseiJoho.get().get認定調査員コード());
        setZenkaiJoho(chosaItakusakiJoho, chosainJoho);
    }

    private void setZenkaiJoho(Optional<INinteichosaItakusakiJoho> chosaItakusakiJoho, Optional<IChosainJoho> chosainJoho) {
        div.getTxtChosaItakusakiCode().setValue(chosaItakusakiJoho.get().get認定調査委託先コード().value());
        div.getTxtChosaItakusakiName().setValue(chosaItakusakiJoho.get().get事業者名称());
        div.getTxtChosainCode().setValue(chosainJoho.get().get認定調査員コード().value());
        div.getTxtChosainName().setValue(chosainJoho.get().get調査員氏名());
    }

    private void createZenkaiJohoManager() {
        shinseiRirekiManager = ShinseiRirekiFactory.getInstance(new SubGyomuCode(div.getHdnDatabaseSubGyomuCode()));
        ninteiShinseiJohoManager = NinteiShinseiJohoManagerFactory.createInstance(new SubGyomuCode(div.getHdnDatabaseSubGyomuCode()));
        koseiShichosonMasterManager = KoseiShichosonMasterFactory.getInstance(new SubGyomuCode(div.getHdnDatabaseSubGyomuCode()));
        chosaItakusakimanager = ChosaItakusakiFactory.getInstance(new SubGyomuCode(div.getHdnDatabaseSubGyomuCode()));
        chosaInmanager = ChosainFactory.getInstance(new SubGyomuCode(div.getHdnDatabaseSubGyomuCode()));
    }

    /**
     * 入力された調査委託先/調査員入力共有子Div情報を全てクリアします。
     */
    public void onClickBtnClear() {
        div.getTxtChosaItakusakiCode().clearValue();
        div.getTxtChosaItakusakiName().clearValue();
        div.getTxtChosainCode().clearValue();
        div.getTxtChosainName().clearValue();
    }

    /**
     * 入力された調査委託先/調査員入力共有子Div情報を更新します。
     */
    public void onClickbtnToroku() {
        //調査委託先を更新します。
        chosaItakusakimanager = ChosaItakusakiFactory.getInstance(new SubGyomuCode(div.getHdnDatabaseSubGyomuCode()));
        INinteichosaItakusakiJoho.Builder chosaItakusakiJohoBuilder = setchosaItakusakiJoho();
        chosaItakusakiJohoBuilder.setNinteichosaItakusakiCode(new ChosaItakusakiCode(div.getTxtChosaItakusakiCode().getValue()));
        chosaItakusakiJohoBuilder.setJigyoshaMeisho(div.getTxtChosaItakusakiName().getValue());
        chosaItakusakiJohoBuilder.setShichosonCode(new LasdecCode(div.getHdnShichosonCode()));
        chosaItakusakimanager.save調査委託先(chosaItakusakiJohoBuilder.build());
        //調査員を更新します。
        chosaInmanager = ChosainFactory.getInstance(new SubGyomuCode(div.getHdnDatabaseSubGyomuCode()));
        IChosainJoho.Builder chosainJohoBuilder = setchosaInJoho();
        chosainJohoBuilder.setNinteichosaItakusakiCode(new ChosaItakusakiCode(div.getTxtChosaItakusakiCode().getValue()));
        chosainJohoBuilder.setNinteiChosainNo(new ChosainCode(div.getTxtChosainCode().getValue()));
        chosainJohoBuilder.setChosainShimei(div.getTxtChosainName().getValue());
        chosainJohoBuilder.setShichosonCode(new LasdecCode(div.getHdnShichosonCode()));
        //TODO 性別 DBZ.KaigoNinteiShinseihaから取得します。
        chosainJohoBuilder.setSeibetsu(new RString("1"));
        chosaInmanager.save調査員(chosainJohoBuilder.build());
    }

    private INinteichosaItakusakiJoho.Builder setchosaItakusakiJoho() {

        Optional<INinteichosaItakusakiJoho> chosaItakusakiJoho
                = isChosaItakusakiJoho();

        if (chosaItakusakiJoho.isPresent()) {
            return chosaItakusakiJoho.get().createBuilderForEdit();
        }
        if (div.getHdnDatabaseSubGyomuCode().equals(SubGyomuCode.DBD介護受給.value())) {
            return HokenshaNinteichosaItakusakiJoho.newBuilder();
        }
        return ShinsakaiNinteichosaItakusakiJoho.newBuilder();

    }

    private Optional<INinteichosaItakusakiJoho> isChosaItakusakiJoho() throws IllegalArgumentException, NullPointerException {
        Optional<INinteichosaItakusakiJoho> chosaItakusakiJoho
                = chosaItakusakimanager.find調査委託先情報(new LasdecCode(div.getHdnShichosonCode()), new ChosaItakusakiCode(div.getTxtChosaItakusakiCode().getValue()));
        return chosaItakusakiJoho;
    }

    private IChosainJoho.Builder setchosaInJoho() {
        Optional<IChosainJoho> chosainJoho
                = isChosainJoho();

        if (chosainJoho.isPresent()) {
            return chosainJoho.get().createBuilderForEdit();
        }

        if (div.getHdnDatabaseSubGyomuCode().equals(SubGyomuCode.DBD介護受給.value())) {
            return HokenshaChosainJoho.newBuilder();
        }
        return ShinsakaiChosainJoho.newBuilder();

    }

    private Optional<IChosainJoho> isChosainJoho() throws NullPointerException, IllegalArgumentException {
        Optional<IChosainJoho> chosainJoho
                = chosaInmanager.find調査員情報(new LasdecCode(div.getHdnShichosonCode()), new ChosaItakusakiCode(div.getTxtChosaItakusakiCode().getValue()),
                        new ChosainCode(div.getTxtChosainCode().getValue()));
        return chosainJoho;
    }

}
