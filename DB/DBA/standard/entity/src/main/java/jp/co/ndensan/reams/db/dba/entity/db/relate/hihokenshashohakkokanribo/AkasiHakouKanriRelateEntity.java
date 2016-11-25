/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 証発行管理リスト情報RelateEntityです。
 *
 * @reamsid_L DBA-0600-020 zhangguopeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AkasiHakouKanriRelateEntity {

    private RString akasihakoumode;
    private RString chouhouTitle;
    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    private boolean koumukumeyifukaflg;
    private boolean renbanfukaflg;
    private boolean hizikehensyuuflg;
    private List<AkasiHakouKanriEntity> akasiHakouKanriEntityList;

}
