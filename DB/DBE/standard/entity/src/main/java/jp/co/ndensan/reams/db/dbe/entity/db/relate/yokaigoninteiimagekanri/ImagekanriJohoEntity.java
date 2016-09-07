/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteiimagekanri;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ管理情報のentityクラスです。
 *
 * @reamsid_L DBE-1670-010 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ImagekanriJohoEntity implements Serializable {

    private ShinseishoKanriNo shinseishoKanriNo;
    private int ninteichosaIraiRirekiNo;
    private int ikenshoIraiRirekiNo;
    private FlexibleDate ninteichosaJisshiYMD;
    private FlexibleDate ninteichosaJuryoYMD;
    private RString gaikyoChosaTextImageKubun;
    private JigyoshaNo chosaItakusakiCode;
    private RString chosainCode;
    private RString gaikyoTokkiTextImageKubun;
    private FlexibleDate ikenshoKinyuYMD;
    private FlexibleDate ikenshoReadYMD;
    private RString shujiiIryoKikanCode;
    private RString shujiiCode;
    private FlexibleDate ninteiShinseiYMD;
    private RDateTime imageSharedFileId;
    private FlexibleDate ninteiShinsakaiKanryoYMD;
    private FlexibleDate centerSoshinYMD;
    private RString shoKisaiHokenshaNo;
    private RString hihokenshaNo;
}
