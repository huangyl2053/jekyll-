/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd492001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.HenKouData;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.ErrordataIchijiTeburuEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DB出力(進捗の取込みエラーリストファイル一時テーブル)のデータの編集ビジネスクラスです。
 *
 * @reamsid_L DBD-1510-030 x_xuliang
 */
public class ErrordataIchijiTeburubusiness {

    private static final int NUM_2 = 2;
    private RString エラーメッセージ;

    /**
     * 進捗の取込みエラーリストをセット
     *
     * @param errormessage RString
     * @param list List<RString>
     * @param entity ErrordataIchijiTeburuEntity
     */
    public void editErrordata(RString errormessage, List<RString> list, ErrordataIchijiTeburuEntity entity) {
        int index = NUM_2;
        エラーメッセージ = errormessage;
        if (!list.get(index++).isNull()) {
            entity.setShikibetsukodo(list.get(index - 1));
        } else {
            entity.setShikibetsukodo(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setHokenshabango(list.get(index - 1));
        } else {
            entity.setHokenshabango(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setHihokenjabango(list.get(index - 1));
        } else {
            entity.setHihokenjabango(RString.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setNinteishinseibi(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setNinteishinseibi(FlexibleDate.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setEdaban(list.get(index - 1));
        } else {
            entity.setEdaban(RString.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setShinseikubunhorei(new Code(list.get(index - 1)));
        } else {
            entity.setShinseikubunhorei(Code.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setShinseikubunshinseiji(new Code(list.get(index - 1)));
        } else {
            entity.setShinseikubunshinseiji(Code.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setTorisakubunkodo(new Code(list.get(index - 1)));
        } else {
            entity.setTorisakubunkodo(Code.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setHihokenjakubun(new Code(list.get(index - 1)));
        } else {
            entity.setHihokenjakubun(Code.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setShinseidaikokubun(new Code(list.get(index - 1)));
        } else {
            entity.setShinseidaikokubun(Code.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setSeinengappi(new FlexibleDate(list.get(index - 1)));
        } else {
            entity.setSeinengappi(FlexibleDate.EMPTY);
        }
        editErrordata2(list, entity, index);
        entity.setEramesseji(エラーメッセージ);
    }

    /**
     * 進捗の取込みエラーリストをセット
     *
     * @param errormessage RString
     * @param hokouentity HenKouData
     * @param entity ErrordataIchijiTeburuEntity
     */
    public void editErrordatabyHenKou(RString errormessage, HenKouData hokouentity, ErrordataIchijiTeburuEntity entity) {
        エラーメッセージ = errormessage;
        entity.setShikibetsukodo(hokouentity.get識別コード());
        entity.setHokenshabango(hokouentity.get保険者番号());
        entity.setHihokenjabango(hokouentity.get被保険者番号());
        entity.setNinteishinseibi(hokouentity.get認定申請日());
        entity.setEdaban(hokouentity.get枝番());
        entity.setShinseikubunhorei(hokouentity.get申請区分_法令コード());
        entity.setShinseikubunshinseiji(hokouentity.get申請区分_申請時コード());
        entity.setTorisakubunkodo(hokouentity.get取下区分コード());
        entity.setHihokenjakubun(hokouentity.get被保険者区分コード());
        entity.setShinseidaikokubun(hokouentity.get申請代行区分コード());
        entity.setSeinengappi(hokouentity.get生年月日());
        entity.setNenrei(hokouentity.get年齢());
        entity.setSeibetsukodo(hokouentity.get性別コード());
        entity.setHihokenjakanashimei(hokouentity.get被保険者ｶﾅ氏名());
        entity.setHihokenjakanjishimei(hokouentity.get被保険者漢字氏名());
        entity.setYubenbango(hokouentity.get郵便番号());
        entity.setJusho(hokouentity.get住所());
        entity.setTenwabango(hokouentity.get電話番号());
        entity.setByoinshisetsutonomeisho(hokouentity.get病院施設等の名称());
        entity.setByoinshisetsutonoshozaichi(hokouentity.get病院施設等の所在地());
        entity.setEramesseji(エラーメッセージ);
    }

    private void editErrordata2(List<RString> list, ErrordataIchijiTeburuEntity entity, int index) {
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setNenrei(Integer.parseInt(list.get(index - 1).toString()));
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setSeibetsukodo(new Code(list.get(index - 1)));
        } else {
            entity.setSeibetsukodo(Code.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setHihokenjakanashimei(new AtenaKanaMeisho(list.get(index - 1)));
        } else {
            entity.setHihokenjakanashimei(AtenaKanaMeisho.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setHihokenjakanjishimei(new AtenaMeisho(list.get(index - 1)));
        } else {
            entity.setHihokenjakanjishimei(AtenaMeisho.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setYubenbango(list.get(index - 1));
        } else {
            entity.setYubenbango(RString.EMPTY);
        }
        if (!list.get(index++).isNull() && !list.get(index - 1).isEmpty()) {
            entity.setJusho(new AtenaJusho(list.get(index - 1)));
        } else {
            entity.setJusho(AtenaJusho.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setTenwabango(list.get(index - 1));
        } else {
            entity.setTenwabango(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setByoinshisetsutonomeisho(list.get(index - 1));
        } else {
            entity.setByoinshisetsutonomeisho(RString.EMPTY);
        }
        if (!list.get(index++).isNull()) {
            entity.setByoinshisetsutonoshozaichi(list.get(index - 1));
        } else {
            entity.setByoinshisetsutonoshozaichi(RString.EMPTY);
        }
    }

}
