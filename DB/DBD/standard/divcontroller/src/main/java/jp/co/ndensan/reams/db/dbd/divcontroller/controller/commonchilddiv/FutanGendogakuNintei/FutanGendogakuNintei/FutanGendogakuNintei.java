/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.FutanGendogakuNintei.FutanGendogakuNintei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.hikazenenkintaishosha.HikazeNenkinTaishosha;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.FutanGendogakuNintei.FutanGendogakuNintei.FutanGendogakuNinteiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.FutanGendogakuNintei.FutanGendogakuNintei.FutanGendogakuNinteiHandler;
import jp.co.ndensan.reams.db.dbd.service.core.hikazeinenkin.HikazeNenkinTaishoshaFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.business.core.date.DateEditor;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 共有子Div「負担限度額認定」のControllerクラスです。
 *
 * @reamsid_L DBD-3560-030 huangh
 */
public class FutanGendogakuNintei {

    private static final int 編集後和暦年_元号年数まで = 3;

    /**
     * 初期化処理です。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<FutanGendogakuNinteiDiv> onLoad(FutanGendogakuNinteiDiv div) {

        if (!ResponseHolder.isReRequest()) {
            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getTxtHiddenHihokenshaNo());
            if (被保険者番号 == null || 被保険者番号.isEmpty()) {
                throw new SystemException("被保険者番号が設定されていません。");
            }

            List<jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei> 表示リスト
                    = getHandler(div).表示リスト取得(被保険者番号);
            if (表示リスト == null || 表示リスト.isEmpty()) {
                return ResponseData.of(div).addMessage(DbdInformationMessages.減免減額_申請情報なし.getMessage()).respond();
            } else {
                ViewStateHolder.put(ViewStateKeys.負担限度額認定申請の情報, new ArrayList<>(表示リスト));
                getHandler(div).initialize(表示リスト);
            }
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 一覧の選択処理です。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<FutanGendogakuNinteiDiv> onSelect_dgFutanGendogakuNinteiList(FutanGendogakuNinteiDiv div) {

        ArrayList<jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei> 表示リスト
                = ViewStateHolder.get(ViewStateKeys.負担限度額認定申請の情報, ArrayList.class);

        RString 被保険者番号 = div.getTxtHiddenHihokenshaNo();
        RString configValue = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        List<HikazeNenkinTaishosha> 非課税年金情報s = HikazeNenkinTaishoshaFinder.createInstance().
                select非課税年金情報(被保険者番号, new RYear(configValue.toString()));
        RString 非課税年金情報;
        RString str1 = new RString("無(");
        RString str2 = new RString("有(");
        RString str3 = new RString("年度");
        RDate 年月日 = new RDate(configValue.toString().concat("0801"));
        if (非課税年金情報s.isEmpty()) {
            非課税年金情報 = str1.concat(DateEditor.to和暦(年月日).toString().substring(0, 編集後和暦年_元号年数まで)).concat(str3);
        } else {
            非課税年金情報 = str2.concat(DateEditor.to和暦(年月日).toString().substring(0, 編集後和暦年_元号年数まで)).concat(str3);
        }
        getHandler(div).詳細表示(表示リスト, 非課税年金情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 閉じる処理です。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<FutanGendogakuNinteiDiv> onClick_closeOK(FutanGendogakuNinteiDiv div) {

        return ResponseData.of(div).dialogOKClose();
    }

    private FutanGendogakuNinteiHandler getHandler(FutanGendogakuNinteiDiv div) {
        return new FutanGendogakuNinteiHandler(div);
    }
}
