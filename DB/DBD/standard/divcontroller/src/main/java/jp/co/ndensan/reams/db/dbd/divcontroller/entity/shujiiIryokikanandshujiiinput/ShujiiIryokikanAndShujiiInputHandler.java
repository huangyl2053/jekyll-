/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.shujiiIryokikanandshujiiinput;

import db.dbd.definition.valueobject.ninteishinsei.ShujiiCode;
import db.dbd.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbd.business.INinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbd.business.IShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbd.business.IShujiiIryokikanJoho;
import jp.co.ndensan.reams.db.dbd.business.IShujiiJoho;
import jp.co.ndensan.reams.db.dbd.realservice.INinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbd.realservice.IShinseiRirekiManager;
import jp.co.ndensan.reams.db.dbd.realservice.IShujiiIryokikanManager;
import jp.co.ndensan.reams.db.dbd.realservice.IShujiiManager;
import jp.co.ndensan.reams.db.dbd.realservice.NinteiShinseiJohoManagerFactory;
import jp.co.ndensan.reams.db.dbd.realservice.ShinseiRirekiFactory;
import jp.co.ndensan.reams.db.dbd.realservice.ShujiiIryokikanManagerFactory;
import jp.co.ndensan.reams.db.dbd.realservice.ShujiiManagerFactory;
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
 * 共有子Div「主治医医療機関＆主治医入力」の状態を変更するクラスです。
 *
 * @author N8235 船山 洋介
 */
public class ShujiiIryokikanAndShujiiInputHandler {

    private final ShujiiIryokikanAndShujiiInputDiv div;
    private IKoseiShichosonMasterManager koseiShichosonMaster;
    private IShinseiRirekiManager shinseiRirekiManager;
    private INinteiShinseiJohoManager ninteiShinseiJohoManager;
    private IShujiiIryokikanManager shujiiIryokikanManager;
    private IShujiiManager shujiiManager;
    private final SubGyomuCode subGyomuCode;

    /**
     * コンストラクタです。
     *
     * @param div 主治医医療機関＆主治医入力Div
     */
    public ShujiiIryokikanAndShujiiInputHandler(ShujiiIryokikanAndShujiiInputDiv div) {
        this.div = div;
        subGyomuCode = new SubGyomuCode(div.getHdnDatabaseSubGyomuCode());
    }

    /**
     * 入力された主治医医療機関コードを元に主治医医療機関名称を画面に表示します。
     */
    public void onBlurTxtShujiiIryokikanCode() {

        IShujiiIryokikanManager createInstance
                = ShujiiIryokikanManagerFactory.createInstance(new SubGyomuCode(div.getHdnDatabaseSubGyomuCode()));

        Optional<IShujiiIryokikanJoho> shujiiIryoKikanJoho
                = createInstance.find主治医医療機関(new LasdecCode(div.getHdnShichosonCode()), new ShujiiIryokikanCode(div.getTxtIryoKikanCode().getValue()));
        if (shujiiIryoKikanJoho.isPresent()) {
            div.getTxtIryoKikanName().setValue(shujiiIryoKikanJoho.get().get医療機関名称());
        }
        div.getTxtIryoKikanName().clearValue();
    }

    /**
     * 入力された主治医医療機関コードを元に主治医医療機関名称を画面に表示します。
     */
    public void onBlurTxtShujiiCode() {

        shujiiManager = ShujiiManagerFactory.
                createInstance(new SubGyomuCode(div.getHdnDatabaseSubGyomuCode()));

        Optional<IShujiiJoho> shujiiJoho = shujiiManager.find主治医(new LasdecCode(div.getHdnShichosonCode()),
                new ShujiiIryokikanCode(div.getTxtIryoKikanCode().getValue()),
                new ShujiiCode(div.getTxtShujiiCode().getValue()));

        if (!shujiiJoho.isPresent()) {
            div.getTxtShujiiName().clearValue();

            return;
        }

        div.getTxtShujiiName().setValue(shujiiJoho.get().get主治医氏名().value());

        if (shujiiJoho.get().is指定医フラグ()) {
            div.getChkShiteii().setSelectedItems(div.getChkShiteii().getDataSource());
        }
    }

    /**
     * 前回申請時の主治医医療機関・主治医情報を画面に表示します。
     */
    public void zenkaijoho() {
        createZenkaiJohoManager(subGyomuCode);

        Optional<IShinseiRirekiJoho> 申請履歴情報
                = shinseiRirekiManager.find申請履歴情報(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()));
        if (申請履歴情報.isPresent()) {
            createZenkaiJoho(申請履歴情報);
        } else {
            clear();
        }

    }

    private void createZenkaiJoho(Optional<IShinseiRirekiJoho> 申請履歴情報) {
        Optional<INinteiShinseiJoho> 前回認定申請情報
                = ninteiShinseiJohoManager.find認定申請情報(申請履歴情報.get().get前回申請管理番号());

        Optional<IKoseiShichosonMaster> 構成市町村マスタ
                = koseiShichosonMaster.find構成市町村(new ShoKisaiHokenshaNo(前回認定申請情報.get().get証記載保険者番号()));

        Optional<IShujiiIryokikanJoho> 主治医医療機関 = shujiiIryokikanManager.find主治医医療機関(
                構成市町村マスタ.get().get市町村コード(), 前回認定申請情報.get().get主治医医療機関コード());

        Optional<IShujiiJoho> 主治医 = shujiiManager.find主治医(構成市町村マスタ.get().get市町村コード(),
                前回認定申請情報.get().get主治医医療機関コード(), 前回認定申請情報.get().get主治医コード());

        setZenkaiJoho(主治医医療機関, 主治医);
    }

    private void createZenkaiJohoManager(SubGyomuCode subGyomuCode) {
        ninteiShinseiJohoManager = NinteiShinseiJohoManagerFactory.createInstance(subGyomuCode);
        shinseiRirekiManager = ShinseiRirekiFactory.getInstance(subGyomuCode);
        shujiiIryokikanManager = ShujiiIryokikanManagerFactory.createInstance(subGyomuCode);
        shujiiManager = ShujiiManagerFactory.createInstance(subGyomuCode);
        koseiShichosonMaster = KoseiShichosonMasterFactory.getInstance(subGyomuCode);
    }

    private void setZenkaiJoho(Optional<IShujiiIryokikanJoho> 主治医医療機関, Optional<IShujiiJoho> 主治医) {
        div.getTxtIryoKikanCode().setValue(主治医医療機関.get().get主治医医療機関コード().value());
        div.getTxtIryoKikanName().setValue(主治医医療機関.get().get医療機関名称());
        div.getTxtShujiiCode().setValue(主治医.get().get主治医コード().value());
        div.getTxtShujiiName().setValue(主治医.get().get主治医氏名().value());
        if (主治医.get().is指定医フラグ()) {
            div.getChkShiteii().setSelectedItems(div.getChkShiteii().getDataSource());
        }
    }

    /**
     * 画面上にセットされた値をクリアします。
     */
    public void clear() {
        div.getTxtIryoKikanCode().clearValue();
        div.getTxtIryoKikanName().clearValue();
        div.getTxtShujiiCode().clearValue();
        div.getTxtShujiiName().clearValue();
        div.getChkShiteii().setSelectedItemsByKey(new ArrayList<RString>());
    }
}
