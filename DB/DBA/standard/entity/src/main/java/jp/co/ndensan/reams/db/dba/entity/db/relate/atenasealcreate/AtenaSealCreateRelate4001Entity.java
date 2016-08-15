/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名シール作成Entity。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AtenaSealCreateRelate4001Entity {

    private ShikibetsuCode 識別コード;
    private AtenaKanaMeisho 氏名カナ;
    private AtenaMeisho 氏名;
    private RString 管内管外区分WK;
    private YubinNo 郵便番号;
    private AtenaJusho 住所;
    private RString バーコード住所;
    private AtenaBanchi 番地;
    private Katagaki 方書;
    private RString 行政区;
    private RString 管内管外区分;
    private AtenaMeisho 世帯主名称;
    private LasdecCode 市町村コード_受給者台帳;
    private ShikibetsuCode 識別コード_受給者台帳;
    private UaFt250FindAtesakiEntity atesakiEntity;
}
