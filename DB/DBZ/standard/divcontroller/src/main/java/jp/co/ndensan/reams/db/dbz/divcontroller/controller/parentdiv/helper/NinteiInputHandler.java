/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.helper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.NinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.dgServiceIchiran_Row;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UDT022CodeTable;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 共有子Div「認定情報」の実装クラスです。
 *
 * @author N8235 船山 洋介
 */
public class NinteiInputHandler {

    private final NinteiInputDiv div;

    private final RString default_ninteikubun_key = new RString("0");
    private final CodeShubetsu serviceshitei_code_shubetsu = new CodeShubetsu("0002");
    private static final int 数字_6 = 6;
    private static final int 数字_12 = 12;
    private static final int 数字_18 = 18;
    private static final int 数字_24 = 24;

    /**
     * コンストラクタです。
     *
     * @param div 認定情報入力Div
     */
    public NinteiInputHandler(NinteiInputDiv div) {
        this.div = div;
    }

    /**
     * 初期化メソッド
     *
     */
    public void intialize() {

        switch (div.getMode_ShoriType()) {

            case NinteiMode:
            case IchibuSoshitsuMode:
            case ShokaiMode:
            case ShokkenShuseiMode:
            case TokushuShuseiMode:
                setJukyushaJoho();
                break;
            default:

                setShiteiService();

        }
    }

    /**
     * 認定区分変更時にモード・選択地を判定し、
     */
    public void onChangeNinteiKubun() {
        if (div.getMode_ShoriType().equals(NinteiInputDiv.ShoriType.NinteiMode)) {
            setReadOnly();
        }
    }

    private void setReadOnly() {

        if (div.getRadNinteiKubun().getSelectedKey().equals(default_ninteikubun_key)) {
            div.getTxtYokaigodoCode().setReadOnly(false);
            div.getTxtYukoKaishiYMD().setReadOnly(false);
            div.getTxtYukoShuryoYMD().setReadOnly(false);
            div.getTxtShinsakaiIken().setReadOnly(false);
            div.getDgServiceIchiran().setReadOnly(false);

        } else {
            div.getTxtYokaigodoCode().setReadOnly(true);
            div.getTxtYukoKaishiYMD().setReadOnly(true);
            div.getTxtYukoShuryoYMD().setReadOnly(true);
            div.getTxtShinsakaiIken().setReadOnly(true);
            div.getDgServiceIchiran().setReadOnly(true);
        }
    }

    /**
     * クリックアクション_onClickSixMonthLater
     */
    public void onClickSixMonthLater() {
        div.getTxtYukoShuryoYMD().setValue(div.getTxtYukoKaishiYMD().getValue().plusMonth(数字_6));

    }

    /**
     * クリックアクション_onClickTwelveMonthLater
     */
    public void onClickTwelveMonthLater() {

        div.getTxtYukoShuryoYMD().setValue(div.getTxtYukoKaishiYMD().getValue().plusMonth(数字_12));

    }

    /**
     * クリックアクション_onClickEighteenMonthLater
     */
    public void onClickEighteenMonthLater() {

        div.getTxtYukoShuryoYMD().setValue(div.getTxtYukoKaishiYMD().getValue().plusMonth(数字_18));

    }

    /**
     * クリックアクション_onClickTwentyfourMonthLater
     */
    public void onClickTwentyfourMonthLater() {

        div.getTxtYukoShuryoYMD().setValue(div.getTxtYukoKaishiYMD().getValue().plusMonth(数字_24));

    }

    /**
     * クリア
     */
    public void clear() {
        div.getTxtNinteiYMD().clearValue();
        div.getTxtShinsakaiIken().clearValue();
        div.getTxtYokaigodoCode().clearValue();
        div.getTxtYokaigodoName().clearValue();
        div.getTxtYukoKaishiYMD().clearValue();
        div.getTxtYukoShuryoYMD().clearValue();

        div.getRadNinteiKubun().setSelectedKey(default_ninteikubun_key);
        div.getChkMinashiKoshinNintei().setSelectedItemsByKey(new ArrayList<RString>());
        div.getDgServiceIchiran().setSelectedItems(new ArrayList<dgServiceIchiran_Row>());
    }

    private void setJukyushaJoho() {
        Optional<JukyushaDaicho> 直近受給者台帳 = Optional.empty();
//        Optional<JukyushaDaicho> 直近受給者台帳 = new JukyushaDaichoManager().get直近受給者台帳(new HihokenshaNo(div.getHdnHihokenshaNo()));
        if (直近受給者台帳.isPresent()) {
            div.getTxtNinteiYMD().setValue(直近受給者台帳.get().get認定年月日());
            div.getTxtYokaigodoCode().setValue(直近受給者台帳.get().get要介護認定状態区分コード().value());
            div.getTxtYukoKaishiYMD().setValue(直近受給者台帳.get().get認定有効期間開始年月日());
            div.getTxtYukoShuryoYMD().setValue(直近受給者台帳.get().get認定有効期間終了年月日());
            div.getTxtYokaigodoName().setValue(YokaigoJotaiKubunSupport.toValue(KoroshoInterfaceShikibetsuCode.toValue(
                    div.getHdnKoroshoIfShikibetsuCode()), 直近受給者台帳.get().get要介護認定状態区分コード().value()).getName());
            setShiteiService(createServiceListSource(直近受給者台帳));
        }

    }

    private List<ServiceShuruiCode> createServiceListSource(Optional<JukyushaDaicho> 直近受給者台帳) {
        List<ServiceShuruiCode> shiteiServiceList = new ArrayList<>();
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類01());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類02());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類03());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類04());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類05());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類06());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類07());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類08());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類09());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類10());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類11());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類12());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類13());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類14());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類15());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類16());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類17());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類18());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類19());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類20());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類21());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類22());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類23());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類24());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類25());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類26());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類27());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類28());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類29());
        shiteiServiceList.add(直近受給者台帳.get().get指定サービス種類30());
        return shiteiServiceList;
    }

    private void setShiteiService(List<ServiceShuruiCode> shiteiServiceList) {

        List<dgServiceIchiran_Row> serviceIchiranList = new ArrayList<>();

        List<UzT0007CodeEntity> codeMaster = CodeMaster.getCode(SubGyomuCode.DBD介護受給, serviceshitei_code_shubetsu);

        for (UDT022CodeTable siteiService : codeMaster) {
            dgServiceIchiran_Row dgServiceIchiran_Row = new dgServiceIchiran_Row(siteiService.getコード().value(), siteiService.getコード名称());
            setSelected(shiteiServiceList, siteiService, dgServiceIchiran_Row);
            serviceIchiranList.add(dgServiceIchiran_Row);
        }
        div.getDgServiceIchiran().setDataSource(serviceIchiranList);
    }

    private void setSelected(List<ServiceShuruiCode> shiteiServiceList, UDT022CodeTable siteiService, dgServiceIchiran_Row dgServiceIchiran_Row) {
        if (shiteiServiceList.contains(new ServiceShuruiCode(siteiService.getコード().value()))) {
            dgServiceIchiran_Row.setSelected(true);
        }
    }

    private void setShiteiService() {
        List<UzT0007CodeEntity> code = CodeMaster.getCode(SubGyomuCode.DBD介護受給, serviceshitei_code_shubetsu);
        List<dgServiceIchiran_Row> serviceIchiranList = new ArrayList<>();
        for (UDT022CodeTable siteiService : code) {
            serviceIchiranList.add(new dgServiceIchiran_Row(siteiService.getコード().value(), siteiService.getコード名称()));
        }
        div.getDgServiceIchiran().setDataSource(serviceIchiranList);
    }
}
