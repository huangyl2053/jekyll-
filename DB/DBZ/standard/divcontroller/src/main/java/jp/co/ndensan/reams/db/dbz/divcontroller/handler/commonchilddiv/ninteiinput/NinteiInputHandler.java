/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteiinput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBDCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputNaiyo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.NinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.dgServiceIchiran_Row;
import jp.co.ndensan.reams.db.dbz.service.core.ninteiinput.NinteiInputFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * DBZ.NinteiInput_認定情報のHandlerクラスです。
 *
 * @reamsid_L DBZ-1300-080 yaodongsheng
 */
public class NinteiInputHandler {

    private final NinteiInputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div DBZ.NinteiInput_認定情報
     */
    public NinteiInputHandler(NinteiInputDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param model NinteiInputDataPassModel
     */
    public void initialize(NinteiInputDataPassModel model) {
        div.setHdnShinseishoKanriNo(model.get申請書管理番号() == null ? RString.EMPTY : model.get申請書管理番号().value());
        if (!RString.isNullOrEmpty(model.get認定区分())) {
            div.getRadNinteiKubun().setSelectedKey(model.get認定区分());
        }
        if (model.getみなし更新認定() != null && !model.getみなし更新認定().isEmpty()) {
            div.getChkMinashiKoshinNintei().setSelectedItemsByKey(model.getみなし更新認定());
        }
        div.setHdnDatabaseSubGyomuCode(model.getSubGyomuCode());
        div.setHdnKoroshoIfShikibetsuCode(model.get厚労省IFコード());
        if (model.get認定年月日() != null) {
            div.getTxtNinteiYMD().setValue(model.get認定年月日());
        } 
        div.getTxtShinsakaiIken().setValue(model.get審査会意見());
        div.getTxtYokaigodoCode().setValue(model.get要介護度コード());
        div.getTxtYokaigodoName().setValue(model.get要介護度名称());
        if (model.get有効開始年月日() != null) {
            div.getTxtYukoKaishiYMD().setValue(model.get有効開始年月日());
        }
        if (model.get有効終了年月日() != null) {
            div.getTxtYukoShuryoYMD().setValue(model.get有効終了年月日());
        }
        NinteiInputFinder ninteiInputFinder = NinteiInputFinder.createInstance();
        List<UzT0007CodeEntity> entityList = CodeMaster.getCode(SubGyomuCode.DBD介護受給,
                DBDCodeShubetsu.指定サービス種類コード.getコード(), FlexibleDate.getNowDate());
        List<dgServiceIchiran_Row> rowList = new ArrayList<>();
        for (UzT0007CodeEntity entity : entityList) {
            dgServiceIchiran_Row row = new dgServiceIchiran_Row();
            row.setCode(entity.getコード().value());
            row.setServiceName(entity.getコード名称());
            rowList.add(row);
        }
        div.getDgServiceIchiran().setDataSource(rowList);
        if (model.getサービス一覧リスト() != null && !model.getサービス一覧リスト().isEmpty()) {
            setSelectIchiran(rowList, model.getサービス一覧リスト());
        } else {
            List<JukyushaDaicho> jukyushaDaichoList = ninteiInputFinder.getサービス(model.get申請書管理番号()).records();
            setSelect(rowList, jukyushaDaichoList);
        }
        if (new RString("TemnyuMode").equals(new RString(div.getMode_ShoriType().toString()))
                || new RString("InputMode").equals(new RString(div.getMode_ShoriType().toString()))
                || new RString("TokushuTsuikaMode").equals(new RString(div.getMode_ShoriType().toString()))
                || new RString("TokushuShuseiMode").equals(new RString(div.getMode_ShoriType().toString()))
                || new RString("TokushuShinseiTorikeshiMode").equals(new RString(div.getMode_ShoriType().toString()))
                || new RString("ShokkenTsuikaMode").equals(new RString(div.getMode_ShoriType().toString()))
                || new RString("ShokkenShuseiMode").equals(new RString(div.getMode_ShoriType().toString()))
                || new RString("KyakkaTorikeshiRirekiShusei").equals(new RString(div.getMode_ShoriType().toString()))) {
            div.getDgServiceIchiran().setReadOnly(false);
        } else {
            div.getDgServiceIchiran().setReadOnly(true);
        }
        if (new RString("InputMode").equals(new RString(div.getMode_ShoriType().toString()))) {
            div.getRadNinteiKubun().setReadOnly(false);
        }
    }

    /**
     * 画面一覧内容を取得。
     *
     * @return NinteiInputNaiyo NinteiInputNaiyo
     */
    public NinteiInputNaiyo getNaiyo() {
        NinteiInputNaiyo naiyo = new NinteiInputNaiyo();
        naiyo.set認定区分(div.getRadNinteiKubun().getSelectedKey());
        naiyo.setみなし更新認定(div.getChkMinashiKoshinNintei().getSelectedKeys());
        naiyo.set認定年月日(div.getTxtNinteiYMD().getValue());
        naiyo.set有効終了年月日(div.getTxtYukoShuryoYMD().getValue());
        naiyo.set有効開始年月日(div.getTxtYukoKaishiYMD().getValue());
        naiyo.set要介護度コード(div.getTxtYokaigodoCode().getValue());
        naiyo.set要介護度名称(div.getTxtYokaigodoName().getValue());
        naiyo.set審査会意見(div.getTxtShinsakaiIken().getValue());
        return naiyo;
    }

    /**
     * Service一覧内容を取得。
     *
     * @return NinteiInputNaiyo NinteiInputNaiyo
     */
    public List<dgServiceIchiran_Row> getServiceRow() {
        List<dgServiceIchiran_Row> rowList = new ArrayList<>();
        for (dgServiceIchiran_Row row : div.getDgServiceIchiran().getDataSource()) {
            if (row.getSelected()) {
                rowList.add(row);
            }
        }
        return rowList;
    }

    private void setSelectIchiran(List<dgServiceIchiran_Row> rowList, List<RString> サービス一覧リスト) {
        for (RString サービスコード : サービス一覧リスト) {
            for (dgServiceIchiran_Row row : rowList) {
                if (row.getCode().equals(サービスコード)) {
                    row.setSelected(true);
                    break;
                }
            }
        }
    }

    private void setSelect(List<dgServiceIchiran_Row> rowList, List<JukyushaDaicho> jukyushaDaichoList) {
        for (dgServiceIchiran_Row row : rowList) {
            for (JukyushaDaicho jukyushaDaicho : jukyushaDaichoList) {
                サービス判断(row, jukyushaDaicho.get指定サービス種類01());
                サービス判断(row, jukyushaDaicho.get指定サービス種類02());
                サービス判断(row, jukyushaDaicho.get指定サービス種類03());
                サービス判断(row, jukyushaDaicho.get指定サービス種類04());
                サービス判断(row, jukyushaDaicho.get指定サービス種類05());
                サービス判断(row, jukyushaDaicho.get指定サービス種類06());
                サービス判断(row, jukyushaDaicho.get指定サービス種類07());
                サービス判断(row, jukyushaDaicho.get指定サービス種類08());
                サービス判断(row, jukyushaDaicho.get指定サービス種類09());
                サービス判断(row, jukyushaDaicho.get指定サービス種類10());
                サービス判断(row, jukyushaDaicho.get指定サービス種類11());
                サービス判断(row, jukyushaDaicho.get指定サービス種類12());
                サービス判断(row, jukyushaDaicho.get指定サービス種類13());
                サービス判断(row, jukyushaDaicho.get指定サービス種類14());
                サービス判断(row, jukyushaDaicho.get指定サービス種類15());
                サービス判断(row, jukyushaDaicho.get指定サービス種類16());
                サービス判断(row, jukyushaDaicho.get指定サービス種類17());
                サービス判断(row, jukyushaDaicho.get指定サービス種類18());
                サービス判断(row, jukyushaDaicho.get指定サービス種類19());
                サービス判断(row, jukyushaDaicho.get指定サービス種類20());
                サービス判断(row, jukyushaDaicho.get指定サービス種類21());
                サービス判断(row, jukyushaDaicho.get指定サービス種類22());
                サービス判断(row, jukyushaDaicho.get指定サービス種類23());
                サービス判断(row, jukyushaDaicho.get指定サービス種類24());
                サービス判断(row, jukyushaDaicho.get指定サービス種類25());
                サービス判断(row, jukyushaDaicho.get指定サービス種類26());
                サービス判断(row, jukyushaDaicho.get指定サービス種類27());
                サービス判断(row, jukyushaDaicho.get指定サービス種類28());
                サービス判断(row, jukyushaDaicho.get指定サービス種類29());
                サービス判断(row, jukyushaDaicho.get指定サービス種類30());
            }
        }
    }

    private void サービス判断(dgServiceIchiran_Row row, ServiceShuruiCode dbCode) {
        if (dbCode != null && row.getCode().equals(dbCode.value())) {
            row.setSelected(true);
        }
    }
}
