    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010001;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010001.SystemKanriNinteiKekkaTotalDiv;
import jp.co.ndensan.reams.db.dbd.service.core.systemkanrininteikekkatotal.SystemKanriNinteiKekkaTotalManager;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBDCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * システム管理登録（認定結果通知書文言変更）画面のHandlerです。
 *
 * @reamsid_L DBD-3760-010 tz_chengpeng
 */
public class SystemKanriNinteiKekkaTotalHandler {

    private static final RString コードマスタ_コード01 = new RString("01");
    private static final RString コードマスタ_コード11 = new RString("11");
    private static final RString コードマスタ_コード12 = new RString("12");
    private static final RString コードマスタ_コード13 = new RString("13");
    private static final RString コードマスタ_コード21 = new RString("21");
    private static final RString コードマスタ_コード22 = new RString("22");
    private static final RString コードマスタ_コード23 = new RString("23");
    private static final RString コードマスタ_コード24 = new RString("24");
    private static final RString コードマスタ_コード25 = new RString("25");

    private RString 付加情報_コンテキスト;

    private final SystemKanriNinteiKekkaTotalDiv div;

    /**
     *
     * @param div SystemKanriNinteiKekkaTotalDiv
     */
    public SystemKanriNinteiKekkaTotalHandler(SystemKanriNinteiKekkaTotalDiv div) {
        this.div = div;
    }

    /**
     * コード名称を取得
     *
     * @param code RString
     * @return コード名称
     */
    private RString getCodeMeiSho(RString code) {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBD介護受給, DBDCodeShubetsu.結果通知理由.getコード(),
                new Code(code), FlexibleDate.getNowDate());
    }

    /**
     * uzT0007CodeEntityを更新
     *
     */
    public void uzT0007CodeEntityデータ更新() {

        Map<RString, RString> uzT0007CodeFuKaJoHoMap = new HashMap<>();
        付加情報_コンテキスト = div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho1().getValue();
        uzT0007CodeFuKaJoHoMap.put(コードマスタ_コード01, 付加情報_コンテキスト);
        付加情報_コンテキスト = div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho2().getValue();
        uzT0007CodeFuKaJoHoMap.put(コードマスタ_コード11, 付加情報_コンテキスト);
        付加情報_コンテキスト = div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho3().getValue();
        uzT0007CodeFuKaJoHoMap.put(コードマスタ_コード12, 付加情報_コンテキスト);
        付加情報_コンテキスト = div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho4().getValue();
        uzT0007CodeFuKaJoHoMap.put(コードマスタ_コード13, 付加情報_コンテキスト);
        付加情報_コンテキスト = div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho5().getValue();
        uzT0007CodeFuKaJoHoMap.put(コードマスタ_コード21, 付加情報_コンテキスト);
        付加情報_コンテキスト = div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho6().getValue();
        uzT0007CodeFuKaJoHoMap.put(コードマスタ_コード22, 付加情報_コンテキスト);
        付加情報_コンテキスト = div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho7().getValue();
        uzT0007CodeFuKaJoHoMap.put(コードマスタ_コード23, 付加情報_コンテキスト);
        付加情報_コンテキスト = div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho8().getValue();
        uzT0007CodeFuKaJoHoMap.put(コードマスタ_コード24, 付加情報_コンテキスト);
        付加情報_コンテキスト = div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho9().getValue();
        uzT0007CodeFuKaJoHoMap.put(コードマスタ_コード25, 付加情報_コンテキスト);

        new SystemKanriNinteiKekkaTotalManager(uzT0007CodeFuKaJoHoMap).uzT0007Codeテーブル更新();
    }

    /**
     * 付加情報初期値設定
     *
     */
    public void setInitializeFuKaJoho() {
        div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho1().setValue(
                getCodeMeiSho(コードマスタ_コード01));
        div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho2().setValue(
                getCodeMeiSho(コードマスタ_コード11));
        div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho3().setValue(
                getCodeMeiSho(コードマスタ_コード12));
        div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho4().setValue(
                getCodeMeiSho(コードマスタ_コード13));
        div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho5().setValue(
                getCodeMeiSho(コードマスタ_コード21));
        div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho6().setValue(
                getCodeMeiSho(コードマスタ_コード22));
        div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho7().setValue(
                getCodeMeiSho(コードマスタ_コード23));
        div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho8().setValue(
                getCodeMeiSho(コードマスタ_コード24));
        div.getSystemKanri().getSystemKanriNinteiKekka().getTplSystemKanri().getTxtFukaJoho9().setValue(
                getCodeMeiSho(コードマスタ_コード25));
    }
}
