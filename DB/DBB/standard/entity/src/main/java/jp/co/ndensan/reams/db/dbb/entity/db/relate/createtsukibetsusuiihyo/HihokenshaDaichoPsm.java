/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import lombok.Getter;
import lombok.Setter;

/**
 * 現年度データのEntityクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class HihokenshaDaichoPsm extends DbTableEntityBase<HihokenshaDaichoPsm> implements IDbAccessable {

    private RString hihokenshaNo;
    private FlexibleDate idoYMD;
    private RString edaNo;
    private RString idoJiyuCode;
    private RString shichosonCode;
    private RString shikibetsuCode;
    private RString shikakuShutokuJiyuCode;
    private FlexibleDate shikakuShutokuYMD;
    private FlexibleDate shikakuShutokuTodokedeYMD;
    private FlexibleDate ichigoShikakuShutokuYMD;
    private RString hihokennshaKubunCode;
    private RString shikakuSoshitsuJiyuCode;
    private FlexibleDate shikakuSoshitsuYMD;
    private FlexibleDate shikakuSoshitsuTodokedeYMD;
    private RString shikakuHenkoJiyuCode;
    private FlexibleDate shikakuHenkoYMD;
    private FlexibleDate shikakuHenkoTodokedeYMD;
    private RString jushochitokureiTekiyoJiyuCode;
    private FlexibleDate jushochitokureiTekiyoYMD;
    private FlexibleDate jushochitokureiTTodokedeYMD;
    private RString jushochitokureiKaijoJiyuCode;
    private FlexibleDate jushochitokureiKaijoYMD;
    private FlexibleDate jushochitokureiKTodokedeYMD;
    private boolean jushochiTokureiFlag;
    private boolean koikinaiJushochiTokureiFlag;
    private RString koikinaiToSShichosonCode;
    private RString kyuShichosonCode;
    private boolean logicalDeletedFlag;
    private RString choikiCode;
    private RString gyoseikuCode;
    private RString gyoseikuName;
    private RString chikuCode1;
    private RString chikuName1;
    private RString chikuCode2;
    private RString chikuName2;
    private RString chikuCode3;
    private RString chikuName3;
    private RString seinengappiYMD;
    private boolean yoGetuSikakuumuFlg;
    private boolean goGetuSikakuumuFlg;
    private boolean rokuGetuSikakuumuFlg;
    private boolean nanaGetuSikakuumuFlg;
    private boolean hatiGetuSikakuumuFlg;
    private boolean kyuGetuSikakuumuFlg;
    private boolean jyuGetuSikakuumuFlg;
    private boolean jyuitiGetuSikakuumuFlg;
    private boolean jyuniGetuSikakuumuFlg;
    private boolean itiGetuSikakuumuFlg;
    private boolean niGetuSikakuumuFlg;
    private boolean sanGetuSikakuumuFlg;

}
