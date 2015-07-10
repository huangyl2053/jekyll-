/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiShinseiTodokedesha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.INinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.IShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.business.IShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbz.definition.JigyoshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.ShinseiTodokedeshaTsuzukigaraCode;
import jp.co.ndensan.reams.db.dbz.realservice.INinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbz.realservice.IShinseiRirekiManager;
import jp.co.ndensan.reams.db.dbz.realservice.IShinseitodokedeJohoManager;
import jp.co.ndensan.reams.db.dbz.realservice.NinteiShinseiJohoManagerFactory;
import jp.co.ndensan.reams.db.dbz.realservice.ShinseiRirekiFactory;
import jp.co.ndensan.reams.db.dbz.realservice.ShinseitodokedeJohoFactory;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;

/**
 * 申請届出者の共有子Divのエンティティに対する操作を行うクラスです。
 *
 * @author n8223 朴義一
 */
public class NinteiShinseiTodokedeshaHandler {

    private final NinteiShinseiTodokedeshaDiv div;
    private IShinseiRirekiManager shinseiRirekiManager;
    private INinteiShinseiJohoManager ninteiShinseiJohoManager;
    private IShinseitodokedeJohoManager shinseitodokedeJohoManager;

    private SubGyomuCode subGyomuCode;

    /**
     * コンストラクタです。
     *
     * @param ninteiShinseiTodokedeshaDiv 申請届出者の共有子Divのエンティティ
     */
    public NinteiShinseiTodokedeshaHandler(NinteiShinseiTodokedeshaDiv ninteiShinseiTodokedeshaDiv) {
        this.div = ninteiShinseiTodokedeshaDiv;
    }

    /**
     * 入力された申請届出者の共有子Div情報を初期化をします。
     */
    public void initialize() {

        //届出代行区分 ddlTodokledeDaikoKubun
        div.getDdlTodokledeDaikoKubun().setDataSource(getTodokledeDaikoKubunDataSource());
        //申請関係者(事業者区分) ddlShinseiKankeisha
        div.getDdlShinseiKankeisha().setDataSource(getShinseiKankeisha());

    }

    private List<KeyValueDataSource> getTodokledeDaikoKubunDataSource() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (ShinseiTodokedeDaikoKubunCode target : ShinseiTodokedeDaikoKubunCode.values()) {
            KeyValueDataSource keyValueData = new KeyValueDataSource(target.getCode(), target.toRString());
            dataSource.add(keyValueData);
        }
        return dataSource;
    }

    private List<KeyValueDataSource> getShinseiKankeisha() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (JigyoshaKubun target : JigyoshaKubun.values()) {
            KeyValueDataSource keyValueData = new KeyValueDataSource(target.getCode(), target.toRString());
            dataSource.add(keyValueData);
        }
        return dataSource;

    }

    /**
     * 入力された申請届出者の共有子Div情報を全てクリアします。
     */
    public void clear() {
        div.getTxtJigyoshaCode().clearValue();
        div.getTxtJigyoshaName().clearValue();
        div.getTxtKanaShimei().clearValue();
        div.getTxtShimei().clearValue();
        div.getTxtHonninKankeisei().clearValue();
        div.getLblHonninKankeiseiMei().setText(RString.EMPTY);
        div.getTxtYubinNo().clearValue();
        div.getTxtTelNo().clearDomain();
        div.getTxtJusho().clearDomain();
    }

    /**
     * ロードをします。
     */
    public void load() {
    }

    /**
     * イベントハンドラ(onChanged_dlTodokedeDaikoKubun)です。<br/>
     * 届出代行区分の選択値により処理を行います。
     */
    public void onChangeDdlTodokedeDaikoKubun() {
        RString selectKey = div.getDdlTodokledeDaikoKubun().getSelectedKey();

        //選択値＝”本人の場合”
        if (selectKey.equals(ShinseiTodokedeDaikoKubunCode.本人.getCode())) {
            div.getTxtShimei().setValue(div.getHdnKanaShimei());
            div.getTxtKanaShimei().setValue(div.getHdnKanaShimei());
            div.getTxtHonninKankeisei().setValue(div.getHdnTsudukigara());
            div.getLblHonninKankeiseiMei().setText(new RString(ShinseiTodokedeshaTsuzukigaraCode.toValue(div.getHdnTsudukigara()).name()));
            div.getTxtYubinNo().setValue(new YubinNo(div.getHdnYubinNo()));
            div.getTxtJusho().setDomain(new AtenaJusho(div.getHdnJusho()));
            div.getTxtTelNo().setDomain(new TelNo(div.getHdnTelNo()));
            //選択値＝”家族”の場合
        } else if (selectKey.equals(ShinseiTodokedeDaikoKubunCode.家族.getCode())) {
            div.getBtnSetaiIchiran().setDisabled(false);
            clear();
            //選択値＝”委任”の場合
        } else if (selectKey.equals(ShinseiTodokedeDaikoKubunCode.委任.getCode())) {
            div.getBtnAtenaKensaku().setDisabled(false);
            clear();
            //選択値=”代行”の場合
        } else if (selectKey.equals(ShinseiTodokedeDaikoKubunCode.代行.getCode())) {
            div.getTxtJigyoshaCode().setReadOnly(false);
            div.getBtnJigyoshaGuide().setDisabled(false);
            div.getDdlShinseiKankeisha().setReadOnly(false);
        } else {
            clear();
            div.getBtnSetaiIchiran().setDisabled(true);
            div.getBtnAtenaKensaku().setDisabled(true);
            div.getTxtJigyoshaCode().setReadOnly(true);
            div.getBtnJigyoshaGuide().setDisabled(true);
            div.getDdlShinseiKankeisha().setReadOnly(true);
        }
    }

    /**
     * イベントハンドラ(onClick_btnZenkaiFukusha)です。<br/>
     * 前回の申請情報の申請届出情報から内容を取得します。
     */
    public void onClickBtnZenkaiFukusha() {
        //①受渡しにフォームのhiddenの申請書管理番号と履歴申請情報で、前回申請管理番号があれば、②-1
        createZenkaiJohoManager();
        Optional<IShinseiRirekiJoho> shinseiRirekiJoho = shinseiRirekiManager.find申請履歴情報(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()));
        if (shinseiRirekiJoho.isPresent()) {
            createZenkaiJoho(shinseiRirekiJoho);
        }
    }

    /**
     * TODO
     */
    public void onBlurJigyoshaGuide() {

    }

    private void createZenkaiJohoManager() {
        shinseiRirekiManager = ShinseiRirekiFactory.getInstance(new SubGyomuCode(div.getHdnGyomuCode()));
        ninteiShinseiJohoManager = NinteiShinseiJohoManagerFactory.createInstance(new SubGyomuCode(div.getHdnGyomuCode()));
        shinseitodokedeJohoManager = ShinseitodokedeJohoFactory.getInstance(new SubGyomuCode(div.getHdnGyomuCode()));
    }

    private void createZenkaiJoho(Optional<IShinseiRirekiJoho> shinseiRirekiJoho) {
        Optional<INinteiShinseiJoho> ninteiShinseiJoho
                = ninteiShinseiJohoManager.find認定申請情報(shinseiRirekiJoho.get().get前回申請管理番号());
        if (ninteiShinseiJoho.isPresent()) {
            Optional<IShinseitodokedeJoho> shinseitodokedeJoho
                    = shinseitodokedeJohoManager.find申請届出者情報(ninteiShinseiJoho.get().get申請書管理番号());
            if (shinseitodokedeJoho.isPresent()) {
                setZenkaiJoho(shinseitodokedeJoho);
            }
        }
    }

    private void setZenkaiJoho(Optional<IShinseitodokedeJoho> shinseitodokedeJoho) {
        div.getTxtShimei().setValue(shinseitodokedeJoho.get().get申請届出者氏名().value());
        div.getTxtKanaShimei().setValue(shinseitodokedeJoho.get().get申請届出者氏名カナ().value());
        //本人と関係性
        div.getTxtHonninKankeisei().setValue(shinseitodokedeJoho.get().get申請届出者続柄コード());
        div.getLblHonninKankeiseiMei().setText(new RString(ShinseiTodokedeshaTsuzukigaraCode.toValue(shinseitodokedeJoho.get().get申請届出者続柄コード()).name()));
        div.getTxtYubinNo().setValue(shinseitodokedeJoho.get().get申請届出者郵便番号());
        div.getTxtTelNo().setDomain((shinseitodokedeJoho.get().get申請届出者電話番号()));
        div.getDdlTodokledeDaikoKubun().setSelectedKey(shinseitodokedeJoho.get().get申請届出代行区分コード().getKey());
        div.getDdlShinseiKankeisha().setSelectedKey(shinseitodokedeJoho.get().get事業者区分());

    }

}
