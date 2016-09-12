/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.dbb021051;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.dbb021051.DBZ100001AtenaSealEntity;
import jp.co.ndensan.reams.db.dbb.business.report.dbb021051.DBZ100001AtenaSealParameterEntity;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb021051.DBB021051ProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051.DBB021051ShoriKekkaListTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051.DBB021051TableJohoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051.HihokenshaAteanAtesakiJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051.KaigoChoshuHohoJohoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB021051_宛名シール作成（介護賦課）のDBB021051DataUtilのクラスです。
 *
 * @reamsid_L DBB-5660-030 liuyang
 */
public class DBB021051DataUtil {

    private final int 市町村コード長さ = 6;
    private final RString str都道府県 = new RString("都道府県");
    private final RString str郡 = new RString("郡");
    private final RString str市町村 = new RString("市町村");
    private final RString str方書 = new RString("方書");
    private final RString str住所 = new RString("住所");
    private final RString str番地 = new RString("番地");
    private final RString str行政区 = new RString("行政区");
    private final RString 宛名シールのタイトル = new RString("宛名シール");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString ERRORKUBUN = new RString("99");

    private boolean 最優先住所がニ;
    private AtenaJusho 住所;
    private AtenaBanchi 番地;
    private Katagaki 方書;
    private RString wk管内管外区分;

    /**
     * toDBB021051TableJohoTempEntityのメソッドです。
     *
     * @param entity KaigoChoshuHohoJohoEntity
     * @param parameter DBB021051ProcessParameter
     * @return DBB021051TableJohoTempEntity
     *
     */
    public DBB021051TableJohoTempEntity toDBB021051TableJohoTempEntity(KaigoChoshuHohoJohoEntity entity,
            DBB021051ProcessParameter parameter) {
        最優先住所がニ = TWO.equals(parameter.get最優先住所());
        DBB021051TableJohoTempEntity result = new DBB021051TableJohoTempEntity();
//        TODO ﾊﾞｯﾁﾊﾟﾗﾒｰﾀ.市町村指定に市町村コード QA 1482
        result.set市町村コード(parameter.get市町村指定に市町村コード());
//        TODO 被保険者番号 QA 1482
        result.set被保険者番号(entity.get被保険者番号());
//        TODO 代納区分名称 QA 1482
        result.set代納区分名称(RString.EMPTY);
        UaFt200FindShikibetsuTaishoEntity 宛名PSM = get宛名PSM(entity);
        UaFt250FindAtesakiEntity 宛先PSM = get宛先PSM(entity);
        set宛名情報(宛名PSM, result);
        住所 = null;
        番地 = null;
        方書 = null;
        wk管内管外区分 = RString.EMPTY;
        if (最優先住所がニ) {
            set最優先住所がニの宛先情報(宛先PSM, result);
        } else {
            set最優先住所がニ以外宛名情報(宛名PSM, result);
        }
        if (ONE.equals(wk管内管外区分)) {
            result.setバーコード住所(getバーコード住所(parameter, 住所, 番地, 方書));
        } else {
            result.setバーコード住所(getバーコード住所(住所, 番地, 方書));
        }
        return result;
    }

    /**
     * toDBB021051TableJohoTempEntityのメソッドです。<br/>
     * 宛名識別対象PSMのみから情報を取得します。
     *
     * @param entity KaigoChoshuHohoJohoEntity
     * @param parameter DBB021051ProcessParameter
     * @return DBB021051TableJohoTempEntity
     *
     */
    public DBB021051TableJohoTempEntity toDBB021051TableJohoTempEntityOnlyAtena(KaigoChoshuHohoJohoEntity entity,
            DBB021051ProcessParameter parameter) {
        最優先住所がニ = TWO.equals(parameter.get最優先住所());
        DBB021051TableJohoTempEntity result = new DBB021051TableJohoTempEntity();
        result.set市町村コード(parameter.get市町村指定に市町村コード());
//        TODO 被保険者番号 QA 1482
        result.set被保険者番号(entity.get被保険者番号());
//        TODO 代納区分名称 QA 1482
        result.set代納区分名称(RString.EMPTY);
        UaFt200FindShikibetsuTaishoEntity 宛名PSM = get宛名PSM(entity);
        UaFt250FindAtesakiEntity 宛先PSM = get宛先PSM(entity);
        set宛名情報(宛名PSM, result);
        住所 = null;
        番地 = null;
        方書 = null;
        wk管内管外区分 = RString.EMPTY;
        set最優先住所がニ以外宛名情報(宛名PSM, result);
        if (最優先住所がニ) {
            wk管内管外区分 = 宛先PSM.getKannaiKangaiKubun();
//        TODO 住所 1494
            住所 = 宛先PSM.getJusho();
            番地 = 宛先PSM.getBanchi();
            方書 = 宛先PSM.getKatagaki();
            result.set住所(住所);
        }
        if (ONE.equals(wk管内管外区分)) {
            result.setバーコード住所(getバーコード住所(parameter, 住所, 番地, 方書));
        } else {
            result.setバーコード住所(getバーコード住所(住所, 番地, 方書));
        }
        return result;
    }

    /**
     * toDBB021051TableJohoTempEntityのメソッドです。
     *
     * @param entity HihokenshaAteanAtesakiJohoEntity
     * @param parameter DBB021051ProcessParameter
     * @return DBB021051TableJohoTempEntity
     */
    public DBB021051TableJohoTempEntity toDBB021051TableJohoTempEntity(HihokenshaAteanAtesakiJohoEntity entity,
            DBB021051ProcessParameter parameter) {
        最優先住所がニ = TWO.equals(parameter.get最優先住所());
        DBB021051TableJohoTempEntity result = new DBB021051TableJohoTempEntity();
        //        TODO ﾊﾞｯﾁﾊﾟﾗﾒｰﾀ.市町村指定に市町村コード QA 1482
        result.set市町村コード(parameter.get市町村指定に市町村コード());
//        TODO 代納区分名称 QA 1482
        result.set代納区分名称(RString.EMPTY);
        DBB021051TableJohoTempEntity 介護情報 = entity.get介護情報一時テーブル();
        DbT1001HihokenshaDaichoEntity 被保険者台帳 = entity.get被保険者台帳();
        UaFt250FindAtesakiEntity 宛先PSM = get宛先PSM(entity);
        住所 = null;
        番地 = null;
        方書 = null;
        wk管内管外区分 = RString.EMPTY;
        set介護情報(介護情報, result);
        set被保険者情報(被保険者台帳, result);
        set宛先情報(宛先PSM, result);
        return result;
    }

    /**
     * getErrorEntityのメソッドです。
     *
     * @return DBB021051ShoriKekkaListTempEntity
     */
    public DBB021051ShoriKekkaListTempEntity getErrorEntity() {
        DBB021051ShoriKekkaListTempEntity error = new DBB021051ShoriKekkaListTempEntity();
        error.setエラー区分(ERRORKUBUN);
        error.setキー1(RString.EMPTY);
        error.setキー2(RString.EMPTY);
        error.setキー3(RString.EMPTY);
        error.setキー4(RString.EMPTY);
        error.setキー5(RString.EMPTY);
        error.set備考(RString.EMPTY);
        error.set被保険者カナ氏名(RString.EMPTY);
        error.set被保険者氏名(RString.EMPTY);
        error.set被保険者番号(RString.EMPTY);
        error.set証記載保険者番号(RString.EMPTY);
        return error;
    }

    /**
     * 帳票用Entityを作成する。
     *
     * @param 市町村コード RString
     * @param 市町村名 RString
     * @param システム日付 RString
     * @return DBZ100001AtenaSealParameterEntity
     */
    public DBZ100001AtenaSealParameterEntity getChohyoParameterEntity(RString 市町村コード, RString 市町村名,
            RString システム日付) {
        DBZ100001AtenaSealParameterEntity parameterEntity = new DBZ100001AtenaSealParameterEntity();
        parameterEntity.set市町村コード(市町村コード);
        parameterEntity.set市町村名称(市町村名);
        parameterEntity.set作成日(システム日付);
        parameterEntity.setタイトル(宛名シールのタイトル);
//        parameterEntity.set郵便番号(nonullRStr(entity.get郵便番号()));
//        parameterEntity.set行政区(entity.get行政区());
////          TODO QA再提出 住所TXT
//        parameterEntity.set住所TXT(get住所TXT(parameter));
//        parameterEntity.set方書1(ONE);
        return parameterEntity;
    }

    /**
     * DBZ100001AtenaSealEntityを作成する。
     *
     * @param parameter DBB021051ProcessParameter
     * @param entity DBB021051TableJohoTempEntity
     * @return DBZ100001AtenaSealEntity
     */
    public DBZ100001AtenaSealEntity getDBZ100001AtenaSealEntity(
            DBB021051ProcessParameter parameter, DBB021051TableJohoTempEntity entity) {
        DBZ100001AtenaSealEntity atena = new DBZ100001AtenaSealEntity();
//        TODO ateanSealを編集する。
        return atena;
    }

//private RString get方書1(DBB021051ProcessParameter parameter,){
//
//}
    /**
     * get市町村コードのメソッドです。
     *
     * @param 市町村指定 RString
     * @return RString
     */
    public RString get市町村指定に市町村コード(RString 市町村指定) {
        if (RString.isNullOrEmpty(市町村指定)) {
            return RString.EMPTY;
        }
        return 市町村指定.substring(0, 市町村コード長さ);
    }

    /**
     * get市町村指定に市町村名称のメソッドです。
     *
     * @param 市町村指定 RString
     * @return RString
     */
    public RString get市町村指定に市町村名称(RString 市町村指定) {
        if (RString.isNullOrEmpty(市町村指定)) {
            return RString.EMPTY;
        }
        return 市町村指定.substring(市町村コード長さ).trim();
    }

    /**
     * intProcessParameterのメソッドです。
     *
     * @param koikiZenShichosonJoho KoikiZenShichosonJoho
     * @param parameter DBB021051ProcessParameter
     */
    public void intProcessParameter(KoikiZenShichosonJoho koikiZenShichosonJoho, DBB021051ProcessParameter parameter) {
        if (koikiZenShichosonJoho == null || parameter == null) {
            return;
        }
        parameter.set市町村名称(koikiZenShichosonJoho.get市町村名称());
        parameter.set都道府県名称(koikiZenShichosonJoho.get都道府県名称());
        parameter.set郡名称(koikiZenShichosonJoho.get郡名称());
        parameter.set市町村指定に市町村コード(get市町村指定に市町村コード(parameter.get市町村指定()));
    }

    /**
     * eqNonullRStrのメソッドです。
     *
     * @param r1 RString
     * @param r2 RString
     * @return boolean
     */
    public boolean eqNonullRStr(RString r1, RString r2) {
        return nonullRStr(r1).equals(nonullRStr(r2));
    }

    private RString get住所TXT(DBB021051ProcessParameter parameter) {
        RString 住所TXT = RString.EMPTY;
        //          TODO 1494 住所TXT
        if (judge宛先住所設定(parameter, str市町村)) {
            住所TXT = 住所TXT.concat(nonullRStr(parameter.get市町村名称()));
        }
        if (judge宛先住所設定(parameter, str都道府県)) {
            住所TXT = 住所TXT.concat(nonullRStr(parameter.get都道府県名称()));
        }
        if (judge宛先住所設定(parameter, str郡)) {
            住所TXT = 住所TXT.concat(nonullRStr(parameter.get郡名称()));
        }
        return 住所TXT;
    }

    private boolean judge宛先住所設定(DBB021051ProcessParameter parameter, RString 判定対象) {
        RString 宛先住所設定 = parameter.get宛先住所設定();
        if (RString.isNullOrEmpty(宛先住所設定)) {
            return false;
        }
        return 宛先住所設定.contains(判定対象);
    }

    private void set介護情報(DBB021051TableJohoTempEntity 介護情報, DBB021051TableJohoTempEntity result) {
        if (介護情報 == null) {
            return;
        }
        result.set氏名カナ(介護情報.get氏名カナ());
        result.set世帯主名称(介護情報.get世帯主名称());
        result.set代納区分名称(介護情報.get代納区分名称());
        result.set住所コード(介護情報.get住所コード());
        result.set被保険者番号(介護情報.get被保険者番号());
        result.set性別(介護情報.get性別());
        result.set住民種別コード(介護情報.get住民種別コード());
        result.set住民状態コード(介護情報.get住民状態コード());
        result.set現全国地方公共団体コード(nonullRStr(介護情報.get現全国地方公共団体コード()));
        result.set生年月日(介護情報.get生年月日());
        if (最優先住所がニ) {
            return;
        }
        result.set氏名(介護情報.get氏名());
        result.setWk管内管外区分(介護情報.getWk管内管外区分());
        result.set郵便番号(介護情報.get郵便番号());
        result.set住所(介護情報.get住所());
        result.setバーコード住所(介護情報.getバーコード住所());
        result.set番地(介護情報.get番地());
        result.set方書(介護情報.get方書());
        result.set行政区(介護情報.get行政区());
        result.set管内管外区分(介護情報.get管内管外区分());
        result.set番地コード(介護情報.get番地コード());
        result.set行政区コード(介護情報.get行政区コード());
        result.set地区コード1(介護情報.get地区コード1());
        result.set地区コード2(介護情報.get地区コード2());
        result.set地区コード3(介護情報.get地区コード3());
        result.set世帯コード(介護情報.get世帯コード());
    }

    private void set被保険者情報(DbT1001HihokenshaDaichoEntity 被保険者台帳, DBB021051TableJohoTempEntity result) {
        if (被保険者台帳 == null) {
            return;
        }
        result.set識別コード(被保険者台帳.getShikibetsuCode());
        result.set市町村コード(nonullRStr(被保険者台帳.getShichosonCode()));
    }

    private void set宛先情報(UaFt250FindAtesakiEntity 宛先PSM, DBB021051TableJohoTempEntity result) {
        if (宛先PSM == null || !最優先住所がニ) {
            return;
        }
        result.set氏名(宛先PSM.getKanjiShimei());
        wk管内管外区分 = 宛先PSM.getKannaiKangaiKubun();
        result.setWk管内管外区分(wk管内管外区分);
        result.set郵便番号(宛先PSM.getYubinNo());
        住所 = 宛先PSM.getJusho();
        番地 = 宛先PSM.getBanchi();
        方書 = 宛先PSM.getKatagaki();
        result.set住所(住所);
//     　TODO QA1494  4．1．2で取得したバーコード住所する。
        result.setバーコード住所(RString.EMPTY);
        result.set番地(番地);
        result.set方書(方書);
        result.set行政区(宛先PSM.getGyoseiku());
        result.set管内管外区分(宛先PSM.getKannaiKangaiKubun());
        result.set番地コード(get番地コード(宛先PSM));
        result.set行政区コード(宛先PSM.getGyoseikuCode());
        result.set地区コード1(宛先PSM.getChikuCode1());
        result.set地区コード2(宛先PSM.getChikuCode2());
        result.set地区コード3(宛先PSM.getChikuCode3());
        result.set世帯コード(宛先PSM.getDainoninSetaiCode());
    }

    private void set宛名情報(UaFt200FindShikibetsuTaishoEntity 宛名PSM, DBB021051TableJohoTempEntity result) {
        if (宛名PSM == null) {
            return;
        }
        result.set識別コード(宛名PSM.getShikibetsuCode());
        result.set氏名カナ(宛名PSM.getKanaMeisho());
        result.set世帯主名称(宛名PSM.getSetainushiMei());
        result.set住所コード(宛名PSM.getZenkokuJushoCode());
        result.set性別(宛名PSM.getSeibetsuCode());
        result.set住民種別コード(宛名PSM.getJuminShubetsuCode());
        result.set住民状態コード(宛名PSM.getJuminJotaiCode());
        result.set現全国地方公共団体コード(nonullRStr(宛名PSM.getGenLasdecCode()));
        result.set生年月日(宛名PSM.getSeinengappiYMD());
    }

    private void set最優先住所がニ以外宛名情報(UaFt200FindShikibetsuTaishoEntity 宛名PSM, DBB021051TableJohoTempEntity result) {
        if (宛名PSM != null) {
            result.set氏名(宛名PSM.getMeisho());
            wk管内管外区分 = 宛名PSM.getKannaiKangaiKubun();
            result.setWk管内管外区分(wk管内管外区分);
            result.set郵便番号(宛名PSM.getYubinNo());
//        TODO 住所 QA1494
            住所 = 宛名PSM.getJusho();
            番地 = 宛名PSM.getBanchi();
            方書 = 宛名PSM.getKatagaki();
            result.set住所(住所);
            result.set番地(番地);
            result.set方書(方書);
            result.set行政区(宛名PSM.getGyoseikuName());
            result.set管内管外区分(宛名PSM.getKannaiKangaiKubun());
            result.set番地コード(get番地コード(宛名PSM));
            result.set行政区コード(宛名PSM.getGyoseikuCode());
            result.set地区コード1(宛名PSM.getChikuCode1());
            result.set地区コード2(宛名PSM.getChikuCode2());
            result.set地区コード3(宛名PSM.getChikuCode3());
            result.set世帯コード(宛名PSM.getSetaiCode());
        }
    }

    private void set最優先住所がニの宛先情報(UaFt250FindAtesakiEntity 宛先PSM, DBB021051TableJohoTempEntity result) {
        if (宛先PSM != null) {
            result.set氏名(宛先PSM.getKanjiShimei());
            wk管内管外区分 = 宛先PSM.getKannaiKangaiKubun();
            result.setWk管内管外区分(wk管内管外区分);
            result.set郵便番号(宛先PSM.getYubinNo());
//        TODO 住所 QA1494
            住所 = 宛先PSM.getJusho();
            番地 = 宛先PSM.getBanchi();
            方書 = 宛先PSM.getKatagaki();
            result.set住所(住所);
            result.set番地(番地);
            result.set方書(方書);
            result.set行政区(宛先PSM.getGyoseiku());
            result.set管内管外区分(宛先PSM.getKannaiKangaiKubun());
            result.set番地コード(get番地コード(宛先PSM));
            result.set行政区コード(宛先PSM.getGyoseikuCode());
            result.set地区コード1(宛先PSM.getChikuCode1());
            result.set地区コード2(宛先PSM.getChikuCode2());
            result.set地区コード3(宛先PSM.getChikuCode3());
            result.set世帯コード(宛先PSM.getDainoninSetaiCode());
        }
    }

    private UaFt200FindShikibetsuTaishoEntity get宛名PSM(KaigoChoshuHohoJohoEntity entity) {
        List<UaFt200FindShikibetsuTaishoEntity> 宛名識別対象List = entity.get宛名識別対象PSM();
        if (宛名識別対象List == null || 宛名識別対象List.isEmpty()) {
            return null;
        }
        return 宛名識別対象List.get(0);
    }

    private UaFt250FindAtesakiEntity get宛先PSM(KaigoChoshuHohoJohoEntity entity) {
        List<UaFt250FindAtesakiEntity> 宛先List = entity.get宛先PSM();
        if (宛先List == null || 宛先List.isEmpty()) {
            return null;
        }
        return 宛先List.get(0);
    }

    private UaFt250FindAtesakiEntity get宛先PSM(HihokenshaAteanAtesakiJohoEntity entity) {
        List<UaFt250FindAtesakiEntity> 宛先List = entity.get宛先PSM();
        if (宛先List == null || 宛先List.isEmpty()) {
            return null;
        }
        return 宛先List.get(0);
    }

    private RString getバーコード住所(DBB021051ProcessParameter parameter, AtenaJusho 住所, AtenaBanchi 番地, Katagaki 方書) {
        RString バーコード住所 = nonullRStr(parameter.get市町村名称());
        バーコード住所 = バーコード住所.concat(nonullRStr(parameter.get都道府県名称()));
        バーコード住所 = バーコード住所.concat(nonullRStr(parameter.get郡名称()));
        バーコード住所 = バーコード住所.concat(nonullRStr(住所));
        バーコード住所 = バーコード住所.concat(nonullRStr(番地));
        バーコード住所 = バーコード住所.concat(nonullRStr(方書));
        return バーコード住所;
    }

    private RString getバーコード住所(AtenaJusho 住所, AtenaBanchi 番地, Katagaki 方書) {
        RString バーコード住所 = nonullRStr(住所);
        バーコード住所 = バーコード住所.concat(nonullRStr(番地));
        バーコード住所 = バーコード住所.concat(nonullRStr(方書));
        return バーコード住所;
    }

    private RString get番地コード(UaFt200FindShikibetsuTaishoEntity 宛名PSM) {
        RString 番地コード = nonullRStr(宛名PSM.getBanchiCode1());
        番地コード = 番地コード.concat(nonullRStr(宛名PSM.getBanchiCode2()));
        番地コード = 番地コード.concat(nonullRStr(宛名PSM.getBanchiCode3()));
        return 番地コード;
    }

    private RString get番地コード(UaFt250FindAtesakiEntity 宛先PSM) {
        RString 番地コード = nonullRStr(宛先PSM.getBanchiCode1());
        番地コード = 番地コード.concat(nonullRStr(宛先PSM.getBanchiCode2()));
        番地コード = 番地コード.concat(nonullRStr(宛先PSM.getBanchiCode3()));
        return 番地コード;
    }

    private RString nonullRStr(RString rstring) {
        if (rstring == null) {
            return RString.EMPTY;
        }
        return rstring;
    }

    private RString nonullRStr(AtenaJusho atenaJusho) {
        if (atenaJusho == null) {
            return RString.EMPTY;
        }
        return atenaJusho.value();
    }

    private RString nonullRStr(AtenaBanchi atenaBanchi) {
        if (atenaBanchi == null) {
            return RString.EMPTY;
        }
        return atenaBanchi.value();
    }

    private RString nonullRStr(Katagaki katagaki) {
        if (katagaki == null) {
            return RString.EMPTY;
        }
        return katagaki.value();
    }

    private RString nonullRStr(BanchiCode banchiCode) {
        if (banchiCode == null) {
            return RString.EMPTY;
        }
        return banchiCode.value();
    }

    private RString nonullRStr(LasdecCode lasdecCode) {
        if (lasdecCode == null) {
            return RString.EMPTY;
        }
        return lasdecCode.value();
    }

    private RString nonullRStr(YubinNo yubinNo) {
        if (yubinNo == null) {
            return RString.EMPTY;
        }
        return yubinNo.value();
    }
}
