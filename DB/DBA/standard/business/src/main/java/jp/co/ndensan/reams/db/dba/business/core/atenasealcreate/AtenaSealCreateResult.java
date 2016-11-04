/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.atenasealcreate;

import jp.co.ndensan.reams.db.dba.definition.processprm.dba090010.AtenaSealCreateProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.AtenaSealCreateRelate4001Entity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.AtenaSealCreateRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.DbTAtenaSealCreateTempTableEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.IChiJiTBLEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.JukyuNinteiShinseityuIgaiEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.ShorikekkarisutoichijiTBLEntity;
import jp.co.ndensan.reams.db.dba.entity.euc.atenasealcreate.AtenaSeelEUCEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 宛名シール作成のビジネスです。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
public class AtenaSealCreateResult {

    private static final RString 現住所 = new RString("genjusho");
    private static final RString ERRORCODE = new RString("99");
    private static final RString WK管内管外区分 = new RString("1");

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
            KoikiZenShichosonJoho koikiZenShichosonJoho) {
        DbTAtenaSealCreateTempTableEntity 一時テーブル1Entity = new DbTAtenaSealCreateTempTableEntity();
        if (entity == null) {
            return 一時テーブル1Entity;
        } else {
            一時テーブル1Entity.setShikibetsuCode(unllToEmpty(entity.getPsmEntity().getShikibetsuCode()));
            一時テーブル1Entity.setKanaMeisho(nullToEmpty(entity.getPsmEntity().getKanaMeisho()));
            一時テーブル1Entity.setShichouzonCode(processParamter.getShichousonshitei());
            一時テーブル1Entity.setSetainushiMei(nullToEmpty(entity.getPsmEntity().getSetainushiMei()));
            一時テーブル1Entity.setDainoukubunmeishou(RString.EMPTY);
            一時テーブル1Entity.setZenkokuJushoCode(nullToEmpty(entity.getPsmEntity().getZenkokuJushoCode()));
            一時テーブル1Entity.setHihokenshaNo(entity.get被保険者番号().value());
            一時テーブル1Entity.setSeibetsuCode(entity.getPsmEntity().getSeibetsuCode());
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                get宛名識別対象PSM_一時テーブル1Entity(entity, 一時テーブル1Entity);
            } else {
                get宛先取得PSM_一時テーブル1Entity(entity, 一時テーブル1Entity);
            }
            setバーコード住所_一時テーブル1Entity(一時テーブル1Entity, processParamter,
                    koikiZenShichosonJoho, entity);
            return 一時テーブル1Entity;
        }
    }

    private void get宛先取得PSM_一時テーブル1Entity(AtenaSealCreateRelateEntity entity,
            DbTAtenaSealCreateTempTableEntity 一時テーブル1Entity) {
        if (entity.getAtesakiEntity() != null) {
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
            一時テーブル1Entity.setChoikiCode(nullToEmpty(entity.getAtesakiEntity().getChoikiCode()));
            一時テーブル1Entity.setSeinengappiYMD(RString.EMPTY);
        }
    }

    private void get宛名識別対象PSM_一時テーブル1Entity(AtenaSealCreateRelateEntity entity,
            DbTAtenaSealCreateTempTableEntity 一時テーブル1Entity) {
        if (entity.getPsmEntity() != null) {
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
            一時テーブル1Entity.setChoikiCode(nullToEmpty(entity.getPsmEntity().getChoikiCode()));
            一時テーブル1Entity.setSeinengappiYMD(nullToEmpty(entity.getPsmEntity().getSeinengappiYMD()));
        }
    }

    private void setバーコード住所_一時テーブル1Entity(DbTAtenaSealCreateTempTableEntity 一時テーブル1Entity,
            AtenaSealCreateProcessParameter processParamter,
            KoikiZenShichosonJoho koikiZenShichosonJoho,
            AtenaSealCreateRelateEntity entity) {
        if (WK管内管外区分.equals(一時テーブル1Entity.getWkKannaiKangaiKubun())) {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                setバーコード住所_一時テーブル1Entity_is現住所(entity, 一時テーブル1Entity, koikiZenShichosonJoho);
            } else {
                if (entity.getAtesakiEntity() != null) {
                    一時テーブル1Entity.setSaiyuusenjyuushu(koikiZenShichosonJoho.get市町村名称()
                            .concat(koikiZenShichosonJoho.get都道府県名称())
                            .concat(koikiZenShichosonJoho.get郡名称())
                            .concat(nullToEmpty(entity.getAtesakiEntity().getJusho()))
                            .concat(nullToEmpty(entity.getAtesakiEntity().getBanchi()))
                            .concat(nullToEmpty(entity.getAtesakiEntity().getKatagaki())));
                } else {
                    一時テーブル1Entity.setSaiyuusenjyuushu(koikiZenShichosonJoho.get市町村名称()
                            .concat(koikiZenShichosonJoho.get都道府県名称())
                            .concat(koikiZenShichosonJoho.get郡名称())
                            .concat(RString.EMPTY)
                            .concat(RString.EMPTY)
                            .concat(RString.EMPTY));
                }
            }
        } else {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                if (entity.getPsmEntity() != null) {
                    一時テーブル1Entity.setSaiyuusenjyuushu(nullToEmpty(entity.getPsmEntity().getJusho())
                            .concat(nullToEmpty(entity.getPsmEntity().getBanchi()))
                            .concat(nullToEmpty(entity.getPsmEntity().getKatagaki())));
                } else {
                    一時テーブル1Entity.setSaiyuusenjyuushu(nullToEmpty(entity.getPsmEntity().getJusho())
                            .concat(RString.EMPTY)
                            .concat(RString.EMPTY));
                }
            } else {
                if (entity.getAtesakiEntity() != null) {
                    一時テーブル1Entity.setSaiyuusenjyuushu(nullToEmpty(entity.getAtesakiEntity().getJusho())
                            .concat(nullToEmpty(entity.getAtesakiEntity().getBanchi()))
                            .concat(nullToEmpty(entity.getAtesakiEntity().getKatagaki())));
                } else {
                    一時テーブル1Entity.setSaiyuusenjyuushu((RString.EMPTY)
                            .concat(RString.EMPTY)
                            .concat(RString.EMPTY));
                }
            }
        }
    }

    private void setバーコード住所_一時テーブル1Entity_is現住所(AtenaSealCreateRelateEntity entity,
            DbTAtenaSealCreateTempTableEntity 一時テーブル1Entity,
            KoikiZenShichosonJoho koikiZenShichosonJoho) {
        if (entity.getPsmEntity() != null) {
            一時テーブル1Entity.setSaiyuusenjyuushu(koikiZenShichosonJoho.get市町村名称()
                    .concat(koikiZenShichosonJoho.get都道府県名称())
                    .concat(koikiZenShichosonJoho.get郡名称())
                    .concat(nullToEmpty(entity.getPsmEntity().getJusho()))
                    .concat(nullToEmpty(entity.getPsmEntity().getBanchi()))
                    .concat(nullToEmpty(entity.getPsmEntity().getKatagaki())));
        } else {
            一時テーブル1Entity.setSaiyuusenjyuushu(koikiZenShichosonJoho.get市町村名称()
                    .concat(koikiZenShichosonJoho.get都道府県名称())
                    .concat(koikiZenShichosonJoho.get郡名称())
                    .concat(RString.EMPTY)
                    .concat(RString.EMPTY)
                    .concat(RString.EMPTY));
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
            KoikiZenShichosonJoho koikiZenShichosonJoho) {
        DbTAtenaSealCreateTempTableEntity 一時テーブル2Entity = new DbTAtenaSealCreateTempTableEntity();
        if (entity == null) {
            return 一時テーブル2Entity;
        } else {
            一時テーブル2Entity.setShikibetsuCode(nullToEmpty(entity.get識別コード()));
            一時テーブル2Entity.setKanaMeisho(nullToEmpty(entity.getPsmEntity().getKanaMeisho()));
            一時テーブル2Entity.setShichouzonCode(nullToEmpty(entity.get市町村コード()));
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                get宛名識別対象PSM_一時テーブル2Entity(entity, 一時テーブル2Entity);
            } else {
                get宛先取得PSM_一時テーブル2Entity(entity, 一時テーブル2Entity);
            }
            一時テーブル2Entity.setSetainushiMei(nullToEmpty(entity.getPsmEntity().getSetainushiMei()));
            一時テーブル2Entity.setDainoukubunmeishou(RString.EMPTY);
            一時テーブル2Entity.setZenkokuJushoCode(nullToEmpty(entity.getPsmEntity().getZenkokuJushoCode()));
            一時テーブル2Entity.setHihokenshaNo(nullToEmpty(entity.get被保険者番号()));
            一時テーブル2Entity.setSeibetsuCode(entity.getPsmEntity().getSeibetsuCode());
            setバーコード住所_一時テーブル2Entity(一時テーブル2Entity, processParamter,
                    koikiZenShichosonJoho, entity);
            return 一時テーブル2Entity;
        }
    }

    private void get宛先取得PSM_一時テーブル2Entity(AtenaSealCreateRelateEntity entity,
            DbTAtenaSealCreateTempTableEntity 一時テーブル2Entity) {
        if (entity.getAtesakiEntity() != null) {
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
            一時テーブル2Entity.setChoikiCode(nullToEmpty(entity.getAtesakiEntity().getChoikiCode()));
            一時テーブル2Entity.setSeinengappiYMD(RString.EMPTY);
        }
    }

    private void get宛名識別対象PSM_一時テーブル2Entity(AtenaSealCreateRelateEntity entity,
            DbTAtenaSealCreateTempTableEntity 一時テーブル2Entity) {
        if (entity.getPsmEntity() != null) {
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
            一時テーブル2Entity.setChoikiCode(nullToEmpty(entity.getPsmEntity().getChoikiCode()));
            一時テーブル2Entity.setSeinengappiYMD(nullToEmpty(entity.getPsmEntity().getSeinengappiYMD()));
        }
    }

    private void setバーコード住所_一時テーブル2Entity(DbTAtenaSealCreateTempTableEntity 一時テーブル2Entity,
            AtenaSealCreateProcessParameter processParamter,
            KoikiZenShichosonJoho koikiZenShichosonJoho,
            AtenaSealCreateRelateEntity entity) {
        if (WK管内管外区分.equals(一時テーブル2Entity.getWkKannaiKangaiKubun())) {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                setバーコード住所_一時テーブル2Entity_is現住所(entity, 一時テーブル2Entity,
                        koikiZenShichosonJoho);
            } else {
                if (entity.getAtesakiEntity() != null) {
                    一時テーブル2Entity.setSaiyuusenjyuushu(koikiZenShichosonJoho.get市町村名称()
                            .concat(koikiZenShichosonJoho.get都道府県名称())
                            .concat(koikiZenShichosonJoho.get郡名称())
                            .concat(nullToEmpty(entity.getAtesakiEntity().getJusho()))
                            .concat(nullToEmpty(entity.getAtesakiEntity().getBanchi()))
                            .concat(nullToEmpty(entity.getAtesakiEntity().getKatagaki())));
                } else {
                    一時テーブル2Entity.setSaiyuusenjyuushu(koikiZenShichosonJoho.get市町村名称()
                            .concat(koikiZenShichosonJoho.get都道府県名称())
                            .concat(koikiZenShichosonJoho.get郡名称())
                            .concat(RString.EMPTY)
                            .concat(RString.EMPTY)
                            .concat(RString.EMPTY));
                }
            }
        } else {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                if (entity.getPsmEntity() != null) {
                    一時テーブル2Entity.setSaiyuusenjyuushu(nullToEmpty(entity.getPsmEntity().getJusho())
                            .concat(nullToEmpty(entity.getPsmEntity().getBanchi()))
                            .concat(nullToEmpty(entity.getPsmEntity().getKatagaki())));
                } else {
                    一時テーブル2Entity.setSaiyuusenjyuushu(nullToEmpty(entity.getPsmEntity().getJusho())
                            .concat(RString.EMPTY)
                            .concat(RString.EMPTY));
                }
            } else {
                if (entity.getAtesakiEntity() != null) {
                    一時テーブル2Entity.setSaiyuusenjyuushu(nullToEmpty(entity.getAtesakiEntity().getJusho())
                            .concat(nullToEmpty(entity.getAtesakiEntity().getBanchi()))
                            .concat(nullToEmpty(entity.getAtesakiEntity().getKatagaki())));
                } else {
                    一時テーブル2Entity.setSaiyuusenjyuushu((RString.EMPTY)
                            .concat(RString.EMPTY)
                            .concat(RString.EMPTY));
                }
            }
        }
    }

    private void setバーコード住所_一時テーブル2Entity_is現住所(AtenaSealCreateRelateEntity entity,
            DbTAtenaSealCreateTempTableEntity 一時テーブル2Entity,
            KoikiZenShichosonJoho koikiZenShichosonJoho) {
        if (entity.getPsmEntity() != null) {
            一時テーブル2Entity.setSaiyuusenjyuushu(koikiZenShichosonJoho.get市町村名称()
                    .concat(koikiZenShichosonJoho.get都道府県名称())
                    .concat(koikiZenShichosonJoho.get郡名称())
                    .concat(nullToEmpty(entity.getPsmEntity().getJusho()))
                    .concat(nullToEmpty(entity.getPsmEntity().getBanchi()))
                    .concat(nullToEmpty(entity.getPsmEntity().getKatagaki())));
        } else {
            一時テーブル2Entity.setSaiyuusenjyuushu(koikiZenShichosonJoho.get市町村名称()
                    .concat(koikiZenShichosonJoho.get都道府県名称())
                    .concat(koikiZenShichosonJoho.get郡名称())
                    .concat(RString.EMPTY)
                    .concat(RString.EMPTY)
                    .concat(RString.EMPTY));
        }
    }

    /**
     * 宛名識別対象一時テーブル3を作成 です。
     *
     * @param entity AtenaSealCreateRelate4001Entity
     * @param processParamter AtenaSealCreateProcessParameter
     * @param koikiZenShichosonJoho koikiZenShichosonJoho
     * @return 一時テーブル4Entity DbTAtenaSealCreateTempTableEntity
     */
    public DbTAtenaSealCreateTempTableEntity set宛名識別対象一時テーブル3(AtenaSealCreateRelate4001Entity entity,
            AtenaSealCreateProcessParameter processParamter,
            KoikiZenShichosonJoho koikiZenShichosonJoho) {
        DbTAtenaSealCreateTempTableEntity 一時テーブル3Entity = new DbTAtenaSealCreateTempTableEntity();
        if (entity == null) {
            return 一時テーブル3Entity;
        } else {
            一時テーブル3Entity.setShikibetsuCode(nullToEmpty(entity.get識別コード_受給者台帳()));
            一時テーブル3Entity.setKanaMeisho(nullToEmpty(entity.get氏名カナ()));
            一時テーブル3Entity.setShichouzonCode(nullToEmpty(entity.get市町村コード_受給者台帳()));
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                一時テーブル3Entity.setMeisho(nullToEmpty(entity.get氏名()));
                一時テーブル3Entity.setWkKannaiKangaiKubun(entity.get管内管外区分());
                一時テーブル3Entity.setJusho(nullToEmpty(entity.get住所()));
                一時テーブル3Entity.setYubinNo(nullToEmpty(entity.get郵便番号()));
                一時テーブル3Entity.setBanchi(nullToEmpty(entity.get番地()));
                一時テーブル3Entity.setKatagaki(nullToEmpty(entity.get方書()));
                一時テーブル3Entity.setGyoseikuName(entity.get行政区());
                一時テーブル3Entity.setKannaiKangaiKubun(entity.get管内管外区分());
            } else {
                get宛先取得PSM_一時テーブル3Entity(entity, 一時テーブル3Entity);
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
            setバーコード住所_一時テーブル3Entity(entity, 一時テーブル3Entity,
                    processParamter, koikiZenShichosonJoho);
            一時テーブル3Entity.setChoikiCode(nullToEmpty(entity.get町域コード()));
            一時テーブル3Entity.setSeinengappiYMD(nullToEmpty(entity.get生年月日()));
            return 一時テーブル3Entity;
        }
    }

    private void setバーコード住所_一時テーブル3Entity(AtenaSealCreateRelate4001Entity entity,
            DbTAtenaSealCreateTempTableEntity 一時テーブル3Entity,
            AtenaSealCreateProcessParameter processParamter,
            KoikiZenShichosonJoho koikiZenShichosonJoho) {
        if (WK管内管外区分.equals(一時テーブル3Entity.getWkKannaiKangaiKubun())) {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                一時テーブル3Entity.setSaiyuusenjyuushu(koikiZenShichosonJoho.get市町村名称()
                        .concat(koikiZenShichosonJoho.get都道府県名称())
                        .concat(koikiZenShichosonJoho.get郡名称())
                        .concat(nullToEmpty(entity.get住所()))
                        .concat(nullToEmpty(entity.get番地()))
                        .concat(nullToEmpty(entity.get方書())));
            } else {
                if (entity.getAtesakiEntity() != null) {
                    一時テーブル3Entity.setSaiyuusenjyuushu(koikiZenShichosonJoho.get市町村名称()
                            .concat(koikiZenShichosonJoho.get都道府県名称())
                            .concat(koikiZenShichosonJoho.get郡名称())
                            .concat(nullToEmpty(entity.getAtesakiEntity().getJusho()))
                            .concat(nullToEmpty(entity.getAtesakiEntity().getBanchi()))
                            .concat(nullToEmpty(entity.getAtesakiEntity().getKatagaki())));
                } else {
                    一時テーブル3Entity.setSaiyuusenjyuushu(koikiZenShichosonJoho.get市町村名称()
                            .concat(koikiZenShichosonJoho.get都道府県名称())
                            .concat(koikiZenShichosonJoho.get郡名称())
                            .concat(RString.EMPTY)
                            .concat(RString.EMPTY)
                            .concat(RString.EMPTY));
                }
            }
        } else {
            一時テーブル3Entity.setSaiyuusenjyuushu(nullToEmpty(entity.get住所())
                    .concat(nullToEmpty(entity.get番地()))
                    .concat(nullToEmpty(entity.get方書())));
        }
    }

    private void get宛先取得PSM_一時テーブル3Entity(AtenaSealCreateRelate4001Entity entity,
            DbTAtenaSealCreateTempTableEntity 一時テーブル3Entity) {
        if (entity.getAtesakiEntity() != null) {
            一時テーブル3Entity.setMeisho(nullToEmpty(entity.getAtesakiEntity().getKanjiShimei()));
            一時テーブル3Entity.setWkKannaiKangaiKubun(entity.getAtesakiEntity().getKannaiKangaiKubun());
            if (WK管内管外区分.equals(entity.getAtesakiEntity().getKannaiKangaiKubun())) {
                一時テーブル3Entity.setJusho(nullToEmpty(entity.getAtesakiEntity().getJusho()));
            } else {
                一時テーブル3Entity.setJusho(nullToEmpty(entity.get住所()));
            }
            一時テーブル3Entity.setYubinNo(nullToEmpty(entity.getAtesakiEntity().getYubinNo()));
            一時テーブル3Entity.setBanchi(nullToEmpty(entity.getAtesakiEntity().getBanchi()));
            一時テーブル3Entity.setKatagaki(nullToEmpty(entity.getAtesakiEntity().getKatagaki()));
            一時テーブル3Entity.setGyoseikuName(entity.getAtesakiEntity().getGyoseiku());
            一時テーブル3Entity.setKannaiKangaiKubun(entity.getAtesakiEntity().getKannaiKangaiKubun());
        }
    }

    /**
     * 宛名識別対象一時テーブル4を作成 です。
     *
     * @param entity entity
     * @return DbTAtenaSealCreateTempTableEntity
     */
    public DbTAtenaSealCreateTempTableEntity set宛名識別対象一時テーブル4(JukyuNinteiShinseityuIgaiEntity entity) {
        DbTAtenaSealCreateTempTableEntity 一時テーブル4Entity = new DbTAtenaSealCreateTempTableEntity();
        if (entity == null) {
            return 一時テーブル4Entity;
        }
        一時テーブル4Entity.setShikibetsuCode(nullToEmpty(entity.get識別コード()));
        一時テーブル4Entity.setKanaMeisho(nullToEmpty(entity.get氏名カナ()));
        一時テーブル4Entity.setShichouzonCode(nullToEmpty(entity.get市町村コード()));
        一時テーブル4Entity.setMeisho(nullToEmpty(entity.get氏名()));
        一時テーブル4Entity.setWkKannaiKangaiKubun(nullToEmpty(entity.getWk管内管外区分()));
        一時テーブル4Entity.setYubinNo(nullToEmpty(entity.get郵便番号()));
        一時テーブル4Entity.setJusho(nullToEmpty(entity.get住所()));
        一時テーブル4Entity.setSaiyuusenjyuushu(nullToEmpty(entity.getバーコード住所()));
        一時テーブル4Entity.setBanchi(nullToEmpty(entity.get番地()));
        一時テーブル4Entity.setKatagaki(nullToEmpty(entity.get方書()));
        一時テーブル4Entity.setGyoseikuName(nullToEmpty(entity.get行政区()));
        一時テーブル4Entity.setKannaiKangaiKubun(nullToEmpty(entity.get管内管外区分()));
        一時テーブル4Entity.setSetainushiMei(nullToEmpty(entity.get世帯主名称()));
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

    /**
     * 宛名識別対象一時テーブル5
     *
     * @param entity entity
     * @return DbTAtenaSealCreateTempTableEntity
     */
    public DbTAtenaSealCreateTempTableEntity set宛名識別対象一時テーブル5(JukyuNinteiShinseityuIgaiEntity entity) {
        DbTAtenaSealCreateTempTableEntity 一時テーブル5Entity = new DbTAtenaSealCreateTempTableEntity();
        if (entity == null) {
            return 一時テーブル5Entity;
        }
        一時テーブル5Entity.setShikibetsuCode(nullToEmpty(entity.get識別コード()));
        一時テーブル5Entity.setKanaMeisho(nullToEmpty(entity.get氏名カナ()));
        一時テーブル5Entity.setShichouzonCode(nullToEmpty(entity.get市町村コード()));
        一時テーブル5Entity.setMeisho(nullToEmpty(entity.get氏名()));
        一時テーブル5Entity.setWkKannaiKangaiKubun(nullToEmpty(entity.getWk管内管外区分()));
        一時テーブル5Entity.setYubinNo(nullToEmpty(entity.get郵便番号()));
        一時テーブル5Entity.setJusho(nullToEmpty(entity.get住所()));
        一時テーブル5Entity.setSaiyuusenjyuushu(nullToEmpty(entity.getバーコード住所()));
        一時テーブル5Entity.setBanchi(nullToEmpty(entity.get番地()));
        一時テーブル5Entity.setKatagaki(nullToEmpty(entity.get方書()));
        一時テーブル5Entity.setGyoseikuName(nullToEmpty(entity.get行政区()));
        一時テーブル5Entity.setKannaiKangaiKubun(nullToEmpty(entity.get管内管外区分()));
        一時テーブル5Entity.setSetainushiMei(nullToEmpty(entity.get世帯主名称()));
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

    /**
     * 処理結果リストCSV
     *
     * @param entity entity
     * @param 連番 連番
     * @return AtenaSeelEUCEntity
     */
    public AtenaSeelEUCEntity set処理結果リストCSV(IChiJiTBLEntity entity, int 連番) {
        AtenaSeelEUCEntity eucEntity = new AtenaSeelEUCEntity();
        if (連番 == 1) {
            eucEntity.set作成日時(getTime(RDate.getNowDate(), RDate.getNowDateTime()));
        } else {
            eucEntity.set作成日時(RString.EMPTY);
        }
        eucEntity.set処理名(entity.getエラー区分());
        eucEntity.set証記載保険者番号(RString.EMPTY);
        eucEntity.set被保険者番号(RString.EMPTY);
        eucEntity.set被保険者カナ氏名(RString.EMPTY);
        eucEntity.set被保険者氏名(RString.EMPTY);
        eucEntity.setエラー内容(entity.getエラー区分());
        eucEntity.set備考(RString.EMPTY);
        return eucEntity;
    }

    /**
     * 処理結果リストCSV
     *
     * @return AtenaSeelEUCEntity
     */
    public AtenaSeelEUCEntity set処理結果リストCSV() {
        AtenaSeelEUCEntity eucEntity = new AtenaSeelEUCEntity();
        eucEntity.set作成日時(RString.EMPTY);
        eucEntity.set処理名(RString.EMPTY);
        eucEntity.set証記載保険者番号(RString.EMPTY);
        eucEntity.set被保険者番号(RString.EMPTY);
        eucEntity.set被保険者カナ氏名(RString.EMPTY);
        eucEntity.set被保険者氏名(RString.EMPTY);
        eucEntity.setエラー内容(RString.EMPTY);
        eucEntity.set備考(RString.EMPTY);
        return eucEntity;
    }

    private RString getTime(RDate date, RDateTime time) {
        RString newDate = date.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString newTime = new RString(time.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).toString());
        return newDate.concat(newTime);
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

    private RString nullToEmpty(RString obj) {
        if (RString.isNullOrEmpty(obj)) {
            return RString.EMPTY;
        }
        return obj;
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

    private RString nullToEmpty(ChoikiCode obj) {
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

    private RString nullToEmpty(FlexibleDate obj) {
        if (obj != null && !obj.isEmpty()) {
            return new RString(obj.toString());
        }
        return RString.EMPTY;
    }

    /**
     * 帳票分類ID「DBZ100001_AtenaSeal」（宛名シール）出力順設定可能項目です。
     */
    public enum ShutsuryokujunEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString(""), new RString("\"郵便番号\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString(""), new RString("\"町域コード\"")),
        /**
         * 番地コード
         */
        番地コード(new RString("0003"), new RString(""), new RString("\"番地コード\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""), new RString("\"行政区コード\"")),
        /**
         * 地区1
         */
        地区1(new RString("0005"), new RString(""), new RString("\"地区1\"")),
        /**
         * 地区2
         */
        地区2(new RString("0006"), new RString(""), new RString("\"地区2\"")),
        /**
         * 地区3
         */
        地区3(new RString("0007"), new RString(""), new RString("\"地区3\"")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString(""), new RString("\"世帯コード\"")),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString(""), new RString("\"識別コード\"")),
        /**
         * 氏名カナ
         */
        氏名カナ(new RString("0010"), new RString(""), new RString("\"氏名カナ\"")),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString(""), new RString("\"生年月日\"")),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString(""), new RString("\"性別\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""), new RString("\"市町村コード\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), new RString("\"被保険者番号\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
            this.項目ID = 項目ID;
            this.フォームフィールド名 = フォームフィールド名;
            this.myBatis項目名 = myBatis項目名;
        }

        @Override
        public RString get項目ID() {
            return 項目ID;
        }

        @Override
        public RString getフォームフィールド名() {
            return フォームフィールド名;
        }

        @Override
        public RString getMyBatis項目名() {
            return myBatis項目名;
        }
    }
}
