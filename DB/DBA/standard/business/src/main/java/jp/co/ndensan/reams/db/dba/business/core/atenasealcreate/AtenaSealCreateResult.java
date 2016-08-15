/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.atenasealcreate;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.processprm.atenasealcreate.AtenaSealCreateProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.AtenaSealCreateRelate4001Entity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.AtenaSealCreateRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.DbTAtenaSealCreateTempTableEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.JukyuNinteiShinseityuIgaiEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.ShorikekkarisutoichijiTBLEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 宛名シール作成のビジネスです。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
public class AtenaSealCreateResult {

    private static final RString 現住所 = new RString("genjusho");
    private static final RString ERRORCODE = new RString("99");

    /**
     * 宛名識別対象一時テーブル1を作成 です。
     *
     * @param entity AtenaSealCreateRelateEntity
     * @param processParamter AtenaSealCreateProcessParameter
     * @param koikiZenShichosonJoho List<KoikiZenShichosonJoho>
     * @return 一時テーブル1Entity DbTAtenaSealCreateTempTableEntity
     */
    public DbTAtenaSealCreateTempTableEntity set宛名識別対象一時テーブル1(AtenaSealCreateRelateEntity entity,
            AtenaSealCreateProcessParameter processParamter,
            List<KoikiZenShichosonJoho> koikiZenShichosonJoho) {
        if (entity == null) {
            return null;
        } else {
            DbTAtenaSealCreateTempTableEntity 一時テーブル1Entity = new DbTAtenaSealCreateTempTableEntity();
            一時テーブル1Entity.setShikibetsuCode(unllToEmpty(entity.getPsmEntity().getShikibetsuCode()));
            一時テーブル1Entity.setKanaMeisho(nullToEmpty(entity.getPsmEntity().getKanaMeisho()));
            一時テーブル1Entity.setShichouzonCode(processParamter.getShichousonshitei());
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                一時テーブル1Entity.setMeisho(nullToEmpty(entity.getPsmEntity().getMeisho()));
                一時テーブル1Entity.setWkKannaiKangaiKubun(entity.getPsmEntity().getKannaiKangaiKubun());
                一時テーブル1Entity.setYubinNo(nullToEmpty(entity.getPsmEntity().getYubinNo()));
                一時テーブル1Entity.setJusho(nullToEmpty(entity.getPsmEntity().getJusho()));
                一時テーブル1Entity.setBanchi(nullToEmpty(entity.getPsmEntity().getBanchi()));
                一時テーブル1Entity.setKatagaki(nullToEmpty(entity.getPsmEntity().getKatagaki()));
                一時テーブル1Entity.setGyoseikuName(entity.getPsmEntity().getGyoseikuName());
                一時テーブル1Entity.setKannaiKangaiKubun(entity.getPsmEntity().getKannaiKangaiKubun());
                RStringBuilder sb = new RStringBuilder();
                sb.append(nullToEmpty(entity.getPsmEntity().getBanchiCode1()));
                sb.append(nullToEmpty(entity.getPsmEntity().getBanchiCode2()));
                sb.append(nullToEmpty(entity.getPsmEntity().getBanchiCode3()));
                RString 番地ｺｰド = sb.toRString();
                一時テーブル1Entity.setBanchiCode(番地ｺｰド);
                一時テーブル1Entity.setGyoseikuCode(nullToEmpty(entity.getPsmEntity().getGyoseikuCode()));
                一時テーブル1Entity.setChikuCode1(nullToEmpty(entity.getPsmEntity().getChikuCode1()));
                一時テーブル1Entity.setChikuCode2(nullToEmpty(entity.getPsmEntity().getChikuCode2()));
                一時テーブル1Entity.setChikuCode3(nullToEmpty(entity.getPsmEntity().getChikuCode3()));
                一時テーブル1Entity.setSetaiCode(nullToEmpty(entity.getPsmEntity().getSetaiCode()));
            } else {
                一時テーブル1Entity.setMeisho(nullToEmpty(entity.getAtesakiEntity().getKanjiShimei()));
                一時テーブル1Entity.setWkKannaiKangaiKubun(entity.getAtesakiEntity().getKannaiKangaiKubun());
                一時テーブル1Entity.setYubinNo(nullToEmpty(entity.getAtesakiEntity().getYubinNo()));
                一時テーブル1Entity.setJusho(nullToEmpty(entity.getAtesakiEntity().getJusho()));
                一時テーブル1Entity.setBanchi(nullToEmpty(entity.getAtesakiEntity().getBanchi()));
                一時テーブル1Entity.setKatagaki(nullToEmpty(entity.getAtesakiEntity().getKatagaki()));
                一時テーブル1Entity.setGyoseikuName(entity.getAtesakiEntity().getGyoseiku());
                一時テーブル1Entity.setKannaiKangaiKubun(entity.getAtesakiEntity().getKannaiKangaiKubun());
                RStringBuilder sb = new RStringBuilder();
                sb.append(nullToEmpty(entity.getAtesakiEntity().getBanchiCode1()));
                sb.append(nullToEmpty(entity.getAtesakiEntity().getBanchiCode2()));
                sb.append(nullToEmpty(entity.getAtesakiEntity().getBanchiCode3()));
                RString 番地ｺｰド = sb.toRString();
                一時テーブル1Entity.setBanchiCode(番地ｺｰド);
                一時テーブル1Entity.setGyoseikuCode(nullToEmpty(entity.getAtesakiEntity().getGyoseikuCode()));
                一時テーブル1Entity.setChikuCode1(nullToEmpty(entity.getAtesakiEntity().getChikuCode1()));
                一時テーブル1Entity.setChikuCode2(nullToEmpty(entity.getAtesakiEntity().getChikuCode2()));
                一時テーブル1Entity.setChikuCode3(nullToEmpty(entity.getAtesakiEntity().getChikuCode3()));
                一時テーブル1Entity.setSetaiCode(nullToEmpty(entity.getAtesakiEntity().getDainoninSetaiCode()));
            }
            一時テーブル1Entity.setSetainushiMei(nullToEmpty(entity.getPsmEntity().getSetainushiMei()));
            一時テーブル1Entity.setDainoukubunmeishou(RString.EMPTY);
            一時テーブル1Entity.setZenkokuJushoCode(nullToEmpty(entity.getPsmEntity().getZenkokuJushoCode()));
            一時テーブル1Entity.setHihokenshaNo(entity.get被保険者番号().value());
            一時テーブル1Entity.setSeibetsuCode(entity.getPsmEntity().getSeibetsuCode());
            return 一時テーブル1Entity;
        }
    }

    /**
     * 処理結果リスト一時TBLを作成 です。
     *
     * @return 一時TBL ShorikekkarisutoichijiTBLEntity
     */
    public ShorikekkarisutoichijiTBLEntity set処理結果リスト一時TBL() {
        ShorikekkarisutoichijiTBLEntity 一時TBL = new ShorikekkarisutoichijiTBLEntity();
        一時TBL.setErrorCode(ERRORCODE);
        一時TBL.setAriShikusaihokenshaBongou(RString.EMPTY);
        一時TBL.setHihoKenshaNo(RString.EMPTY);
        一時TBL.setKey1(RString.EMPTY);
        一時TBL.setKey2(RString.EMPTY);
        一時TBL.setKey3(RString.EMPTY);
        一時TBL.setKey4(RString.EMPTY);
        一時TBL.setKey5(RString.EMPTY);
        一時TBL.setKanaShimei(RString.EMPTY);
        一時TBL.setShiMei(RString.EMPTY);
        一時TBL.setBiKou(RString.EMPTY);
        return 一時TBL;
    }

    /**
     * 宛名識別対象一時テーブル2を作成 です。
     *
     * @param entity AtenaSealCreateRelateEntity
     * @param processParamter AtenaSealCreateProcessParameter
     * @param koikiZenShichosonJoho List<KoikiZenShichosonJoho>
     * @return 一時テーブル2Entity DbTAtenaSealCreateTempTableEntity
     */
    public DbTAtenaSealCreateTempTableEntity set宛名識別対象一時テーブル2(AtenaSealCreateRelateEntity entity,
            AtenaSealCreateProcessParameter processParamter,
            List<KoikiZenShichosonJoho> koikiZenShichosonJoho) {
        if (entity == null) {
            return null;
        } else {
            DbTAtenaSealCreateTempTableEntity 一時テーブル2Entity = new DbTAtenaSealCreateTempTableEntity();
            一時テーブル2Entity.setShikibetsuCode(nullToEmpty(entity.get識別コード()));
            一時テーブル2Entity.setKanaMeisho(nullToEmpty(entity.getPsmEntity().getKanaMeisho()));
            一時テーブル2Entity.setShichouzonCode(nullToEmpty(entity.get市町村コード()));
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                一時テーブル2Entity.setMeisho(nullToEmpty(entity.getPsmEntity().getMeisho()));
                一時テーブル2Entity.setWkKannaiKangaiKubun(entity.getPsmEntity().getKannaiKangaiKubun());
                一時テーブル2Entity.setYubinNo(nullToEmpty(entity.getPsmEntity().getYubinNo()));
                一時テーブル2Entity.setJusho(nullToEmpty(entity.getPsmEntity().getJusho()));
                一時テーブル2Entity.setBanchi(nullToEmpty(entity.getPsmEntity().getBanchi()));
                一時テーブル2Entity.setKatagaki(nullToEmpty(entity.getPsmEntity().getKatagaki()));
                一時テーブル2Entity.setGyoseikuName(entity.getPsmEntity().getGyoseikuName());
                一時テーブル2Entity.setKannaiKangaiKubun(entity.getPsmEntity().getKannaiKangaiKubun());
                RStringBuilder sb = new RStringBuilder();
                sb.append(nullToEmpty(entity.getPsmEntity().getBanchiCode1()));
                sb.append(nullToEmpty(entity.getPsmEntity().getBanchiCode2()));
                sb.append(nullToEmpty(entity.getPsmEntity().getBanchiCode3()));
                RString 番地ｺｰド = sb.toRString();
                一時テーブル2Entity.setBanchiCode(番地ｺｰド);
                一時テーブル2Entity.setGyoseikuCode(nullToEmpty(entity.getPsmEntity().getGyoseikuCode()));
                一時テーブル2Entity.setChikuCode1(nullToEmpty(entity.getPsmEntity().getChikuCode1()));
                一時テーブル2Entity.setChikuCode2(nullToEmpty(entity.getPsmEntity().getChikuCode2()));
                一時テーブル2Entity.setChikuCode3(nullToEmpty(entity.getPsmEntity().getChikuCode3()));
                一時テーブル2Entity.setSetaiCode(nullToEmpty(entity.getPsmEntity().getSetaiCode()));
            } else {
                一時テーブル2Entity.setMeisho(nullToEmpty(entity.getAtesakiEntity().getKanjiShimei()));
                一時テーブル2Entity.setWkKannaiKangaiKubun(entity.getAtesakiEntity().getKannaiKangaiKubun());
                一時テーブル2Entity.setYubinNo(nullToEmpty(entity.getAtesakiEntity().getYubinNo()));
                一時テーブル2Entity.setJusho(nullToEmpty(entity.getAtesakiEntity().getJusho()));
                一時テーブル2Entity.setBanchi(nullToEmpty(entity.getAtesakiEntity().getBanchi()));
                一時テーブル2Entity.setKatagaki(nullToEmpty(entity.getAtesakiEntity().getKatagaki()));
                一時テーブル2Entity.setGyoseikuName(entity.getAtesakiEntity().getGyoseiku());
                一時テーブル2Entity.setKannaiKangaiKubun(entity.getAtesakiEntity().getKannaiKangaiKubun());
                RStringBuilder sb = new RStringBuilder();
                sb.append(nullToEmpty(entity.getAtesakiEntity().getBanchiCode1()));
                sb.append(nullToEmpty(entity.getAtesakiEntity().getBanchiCode2()));
                sb.append(nullToEmpty(entity.getAtesakiEntity().getBanchiCode3()));
                RString 番地ｺｰド = sb.toRString();
                一時テーブル2Entity.setBanchiCode(番地ｺｰド);
                一時テーブル2Entity.setGyoseikuCode(nullToEmpty(entity.getAtesakiEntity().getGyoseikuCode()));
                一時テーブル2Entity.setChikuCode1(nullToEmpty(entity.getAtesakiEntity().getChikuCode1()));
                一時テーブル2Entity.setChikuCode2(nullToEmpty(entity.getAtesakiEntity().getChikuCode2()));
                一時テーブル2Entity.setChikuCode3(nullToEmpty(entity.getAtesakiEntity().getChikuCode3()));
                一時テーブル2Entity.setSetaiCode(nullToEmpty(entity.getAtesakiEntity().getDainoninSetaiCode()));
            }
            一時テーブル2Entity.setSetainushiMei(nullToEmpty(entity.getPsmEntity().getSetainushiMei()));
            一時テーブル2Entity.setDainoukubunmeishou(RString.EMPTY);
            一時テーブル2Entity.setZenkokuJushoCode(nullToEmpty(entity.getPsmEntity().getZenkokuJushoCode()));
            一時テーブル2Entity.setHihokenshaNo(nullToEmpty(entity.get被保険者番号()));
            一時テーブル2Entity.setSeibetsuCode(entity.getPsmEntity().getSeibetsuCode());
            return 一時テーブル2Entity;
        }
    }

    /**
     * 宛名識別対象一時テーブル3を作成 です。
     *
     * @param entity AtenaSealCreateRelate4001Entity
     * @param processParamter AtenaSealCreateProcessParameter
     * @return 一時テーブル4Entity DbTAtenaSealCreateTempTableEntity
     */
    public DbTAtenaSealCreateTempTableEntity set宛名識別対象一時テーブル3(AtenaSealCreateRelate4001Entity entity,
            AtenaSealCreateProcessParameter processParamter) {
        if (entity == null) {
            return null;
        } else {
            DbTAtenaSealCreateTempTableEntity 一時テーブル3Entity = new DbTAtenaSealCreateTempTableEntity();
            一時テーブル3Entity.setShikibetsuCode(nullToEmpty(entity.get識別コード_受給者台帳()));
            一時テーブル3Entity.setKanaMeisho(nullToEmpty(entity.get氏名カナ()));
            一時テーブル3Entity.setShichouzonCode(entity.get市町村コード_受給者台帳().value());
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                一時テーブル3Entity.setMeisho(nullToEmpty(entity.get氏名()));
                一時テーブル3Entity.setWkKannaiKangaiKubun(entity.get管内管外区分());
                一時テーブル3Entity.setYubinNo(nullToEmpty(entity.get郵便番号()));
                一時テーブル3Entity.setBanchi(nullToEmpty(entity.get番地()));
                一時テーブル3Entity.setKatagaki(nullToEmpty(entity.get方書()));
                一時テーブル3Entity.setGyoseikuName(entity.get行政区());
                一時テーブル3Entity.setKannaiKangaiKubun(entity.get管内管外区分());
            } else {
                一時テーブル3Entity.setMeisho(nullToEmpty(entity.getAtesakiEntity().getKanjiShimei()));
                一時テーブル3Entity.setWkKannaiKangaiKubun(entity.getAtesakiEntity().getKannaiKangaiKubun());
                一時テーブル3Entity.setYubinNo(nullToEmpty(entity.getAtesakiEntity().getYubinNo()));
                一時テーブル3Entity.setBanchi(nullToEmpty(entity.getAtesakiEntity().getBanchi()));
                一時テーブル3Entity.setKatagaki(nullToEmpty(entity.getAtesakiEntity().getKatagaki()));
                一時テーブル3Entity.setGyoseikuName(entity.getAtesakiEntity().getGyomuGroupName());
                一時テーブル3Entity.setKannaiKangaiKubun(entity.getAtesakiEntity().getKannaiKangaiKubun());
            }
            一時テーブル3Entity.setSetainushiMei(nullToEmpty(entity.get世帯主名称()));
            一時テーブル3Entity.setDainoukubunmeishou(RString.EMPTY);
            一時テーブル3Entity.setBanchiCode(RString.EMPTY);
            一時テーブル3Entity.setGyoseikuCode(RString.EMPTY);
            一時テーブル3Entity.setChikuCode1(RString.EMPTY);
            一時テーブル3Entity.setChikuCode2(RString.EMPTY);
            一時テーブル3Entity.setChikuCode3(RString.EMPTY);
            一時テーブル3Entity.setSetaiCode(RString.EMPTY);
            一時テーブル3Entity.setZenkokuJushoCode(RString.EMPTY);
            一時テーブル3Entity.setHihokenshaNo(RString.EMPTY);
            一時テーブル3Entity.setSeibetsuCode(RString.EMPTY);
            return 一時テーブル3Entity;
        }
    }

    /**
     * 宛名識別対象一時テーブル4を作成 です。
     *
     * @param list JukyuNinteiShinseityuIgaiEntity
     * @return 一時テーブル4Entity DbTAtenaSealCreateTempTableEntity
     */
    public DbTAtenaSealCreateTempTableEntity set宛名識別対象一時テーブル4(JukyuNinteiShinseityuIgaiEntity list) {
        if (list == null) {
            return null;
        } else {
            DbTAtenaSealCreateTempTableEntity 一時テーブル4Entity = new DbTAtenaSealCreateTempTableEntity();
            一時テーブル4Entity.setShikibetsuCode(nullToEmpty(list.get識別コード()));
            一時テーブル4Entity.setKanaMeisho(nullToEmpty(list.get氏名カナ()));
            一時テーブル4Entity.setShichouzonCode(list.get市町村コード());
            一時テーブル4Entity.setMeisho(nullToEmpty(list.get氏名()));
            一時テーブル4Entity.setWkKannaiKangaiKubun(list.getWk管内管外区分());
            一時テーブル4Entity.setYubinNo(nullToEmpty(list.get郵便番号()));
            一時テーブル4Entity.setJusho(nullToEmpty(list.get住所()));
            一時テーブル4Entity.setSaiyuusenjyuushu(list.getバーコード住所());
            一時テーブル4Entity.setBanchi(nullToEmpty(list.get番地()));
            一時テーブル4Entity.setKatagaki(nullToEmpty(list.get方書()));
            一時テーブル4Entity.setGyoseikuName(list.get行政区());
            一時テーブル4Entity.setKannaiKangaiKubun(list.get管内管外区分());
            一時テーブル4Entity.setSetainushiMei(nullToEmpty(list.get世帯主名称()));
            一時テーブル4Entity.setDainoukubunmeishou(RString.EMPTY);
            一時テーブル4Entity.setBanchiCode(RString.EMPTY);
            一時テーブル4Entity.setGyoseikuCode(RString.EMPTY);
            一時テーブル4Entity.setChikuCode1(RString.EMPTY);
            一時テーブル4Entity.setChikuCode2(RString.EMPTY);
            一時テーブル4Entity.setChikuCode3(RString.EMPTY);
            一時テーブル4Entity.setSetaiCode(RString.EMPTY);
            一時テーブル4Entity.setZenkokuJushoCode(RString.EMPTY);
            一時テーブル4Entity.setHihokenshaNo(RString.EMPTY);
            一時テーブル4Entity.setSeibetsuCode(RString.EMPTY);
            return 一時テーブル4Entity;
        }
    }

    /**
     * 宛名識別対象一時テーブル5を作成 です。
     *
     * @param list JukyuNinteiShinseityuIgaiEntity
     * @return 一時テーブル5Entity DbTAtenaSealCreateTempTableEntity
     */
    public DbTAtenaSealCreateTempTableEntity set宛名識別対象一時テーブル5(JukyuNinteiShinseityuIgaiEntity list) {
        if (list == null) {
            return null;
        } else {
            DbTAtenaSealCreateTempTableEntity 一時テーブル5Entity = new DbTAtenaSealCreateTempTableEntity();
            一時テーブル5Entity.setShikibetsuCode(nullToEmpty(list.get識別コード()));
            一時テーブル5Entity.setKanaMeisho(nullToEmpty(list.get氏名カナ()));
            一時テーブル5Entity.setShichouzonCode(list.get市町村コード());
            一時テーブル5Entity.setMeisho(nullToEmpty(list.get氏名()));
            一時テーブル5Entity.setWkKannaiKangaiKubun(list.getWk管内管外区分());
            一時テーブル5Entity.setYubinNo(nullToEmpty(list.get郵便番号()));
            一時テーブル5Entity.setJusho(nullToEmpty(list.get住所()));
            一時テーブル5Entity.setSaiyuusenjyuushu(list.getバーコード住所());
            一時テーブル5Entity.setBanchi(nullToEmpty(list.get番地()));
            一時テーブル5Entity.setKatagaki(nullToEmpty(list.get方書()));
            一時テーブル5Entity.setGyoseikuName(list.get行政区());
            一時テーブル5Entity.setKannaiKangaiKubun(list.get管内管外区分());
            一時テーブル5Entity.setSetainushiMei(nullToEmpty(list.get世帯主名称()));
            一時テーブル5Entity.setDainoukubunmeishou(RString.EMPTY);
            一時テーブル5Entity.setBanchiCode(RString.EMPTY);
            一時テーブル5Entity.setGyoseikuCode(RString.EMPTY);
            一時テーブル5Entity.setChikuCode1(RString.EMPTY);
            一時テーブル5Entity.setChikuCode2(RString.EMPTY);
            一時テーブル5Entity.setChikuCode3(RString.EMPTY);
            一時テーブル5Entity.setSetaiCode(RString.EMPTY);
            一時テーブル5Entity.setZenkokuJushoCode(RString.EMPTY);
            一時テーブル5Entity.setHihokenshaNo(RString.EMPTY);
            一時テーブル5Entity.setSeibetsuCode(RString.EMPTY);
            return 一時テーブル5Entity;
        }
    }

    private RString unllToEmpty(ShikibetsuCode obj) {
        if (obj != null && !obj.isEmpty()) {
            return obj.value();
        }
        return RString.EMPTY;
    }

    private RString nullToEmpty(AtenaKanaMeisho obj) {
        if (obj != null && !obj.isEmpty()) {
            return obj.value();
        }
        return RString.EMPTY;
    }

    private RString nullToEmpty(AtenaMeisho obj) {
        if (obj != null && !obj.isEmpty()) {
            return obj.value();
        }
        return RString.EMPTY;
    }

    private RString nullToEmpty(YubinNo obj) {
        if (obj != null && !obj.isEmpty()) {
            return obj.value();
        }
        return RString.EMPTY;
    }

    private RString nullToEmpty(AtenaJusho obj) {
        if (obj != null && !obj.isEmpty()) {
            return obj.value();
        }
        return RString.EMPTY;
    }

    private RString nullToEmpty(AtenaBanchi obj) {
        if (obj != null && !obj.isEmpty()) {
            return obj.value();
        }
        return RString.EMPTY;
    }

    private RString nullToEmpty(Katagaki obj) {
        if (obj != null && !obj.isEmpty()) {
            return obj.value();
        }
        return RString.EMPTY;
    }

    private RString nullToEmpty(BanchiCode obj) {
        if (obj != null && !obj.isEmpty()) {
            return obj.value();
        }
        return RString.EMPTY;
    }

    private RString nullToEmpty(GyoseikuCode obj) {
        if (obj != null && !obj.isEmpty()) {
            return obj.value();
        }
        return RString.EMPTY;
    }

    private RString nullToEmpty(ChikuCode obj) {
        if (obj != null && !obj.isEmpty()) {
            return obj.value();
        }
        return RString.EMPTY;
    }

    private RString nullToEmpty(SetaiCode obj) {
        if (obj != null && !obj.isEmpty()) {
            return obj.value();
        }
        return RString.EMPTY;
    }

    private RString nullToEmpty(ZenkokuJushoCode obj) {
        if (obj != null && !obj.isEmpty()) {
            return obj.value();
        }
        return RString.EMPTY;
    }

    private RString nullToEmpty(ShikibetsuCode obj) {
        if (obj != null && !obj.isEmpty()) {
            return obj.value();
        }
        return RString.EMPTY;
    }

    private RString nullToEmpty(LasdecCode obj) {
        if (obj != null && !obj.isEmpty()) {
            return obj.value();
        }
        return RString.EMPTY;
    }

    private RString nullToEmpty(HihokenshaNo obj) {
        if (obj != null && !obj.isEmpty()) {
            return obj.value();
        }
        return RString.EMPTY;
    }

}
