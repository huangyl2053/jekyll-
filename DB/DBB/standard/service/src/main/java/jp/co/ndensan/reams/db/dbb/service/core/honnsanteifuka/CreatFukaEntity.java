/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.honnsanteifuka;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.SetaiTempEntity;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 賦課を作成のクラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
public class CreatFukaEntity {

    /**
     * にて生成した{@link CreatFukaEntity}のインスタンスを返します。
     *
     * @return CreatFukaEntity
     */
    public static CreatFukaEntity createInstance() {
        return InstanceProvider.create(CreatFukaEntity.class);
    }

    /**
     * 世帯員所得情報Listを作成のメソッドです。
     *
     * @param 世帯員所得情報Entity SetaiTempEntity
     * @return List<SetaiShotokuEntity>
     */
    public List<SetaiShotokuEntity> get世帯員所得情報List(SetaiTempEntity 世帯員所得情報Entity) {
        List<SetaiShotokuEntity> 世帯員所得情報List = new ArrayList<>();
        set世帯員所得情報_1(世帯員所得情報Entity, 世帯員所得情報List);
        set世帯員所得情報_2(世帯員所得情報Entity, 世帯員所得情報List);
        set世帯員所得情報_3(世帯員所得情報Entity, 世帯員所得情報List);
        set世帯員所得情報_4(世帯員所得情報Entity, 世帯員所得情報List);
        set世帯員所得情報_5(世帯員所得情報Entity, 世帯員所得情報List);
        set世帯員所得情報_6(世帯員所得情報Entity, 世帯員所得情報List);
        set世帯員所得情報_7(世帯員所得情報Entity, 世帯員所得情報List);
        set世帯員所得情報_8(世帯員所得情報Entity, 世帯員所得情報List);
        set世帯員所得情報_9(世帯員所得情報Entity, 世帯員所得情報List);
        set世帯員所得情報_10(世帯員所得情報Entity, 世帯員所得情報List);
        return 世帯員所得情報List;
    }

    private void set世帯員所得情報_10(SetaiTempEntity 世帯員所得情報Entity, List<SetaiShotokuEntity> 世帯員所得情報List) {
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_46() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_46() != null) {
            SetaiShotokuEntity entity46 = new SetaiShotokuEntity();
            entity46.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_46());
            entity46.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_46());
            entity46.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_46());
            entity46.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_46());
            entity46.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_46());
            entity46.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_46());
            entity46.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_46());
            entity46.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_46());
            entity46.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_46());
            entity46.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_46());
            entity46.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_46());
            entity46.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_46());
            entity46.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_46());
            entity46.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_46());
            entity46.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_46());
            世帯員所得情報List.add(entity46);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_47() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_47() != null) {
            SetaiShotokuEntity entity47 = new SetaiShotokuEntity();
            entity47.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_47());
            entity47.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_47());
            entity47.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_47());
            entity47.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_47());
            entity47.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_47());
            entity47.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_47());
            entity47.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_47());
            entity47.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_47());
            entity47.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_47());
            entity47.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_47());
            entity47.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_47());
            entity47.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_47());
            entity47.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_47());
            entity47.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_47());
            entity47.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_47());
            世帯員所得情報List.add(entity47);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_48() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_48() != null) {
            SetaiShotokuEntity entity48 = new SetaiShotokuEntity();
            entity48.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_48());
            entity48.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_48());
            entity48.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_48());
            entity48.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_48());
            entity48.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_48());
            entity48.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_48());
            entity48.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_48());
            entity48.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_48());
            entity48.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_48());
            entity48.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_48());
            entity48.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_48());
            entity48.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_48());
            entity48.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_48());
            entity48.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_48());
            entity48.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_48());
            世帯員所得情報List.add(entity48);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_49() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_49() != null) {
            SetaiShotokuEntity entity49 = new SetaiShotokuEntity();
            entity49.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_49());
            entity49.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_49());
            entity49.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_49());
            entity49.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_49());
            entity49.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_49());
            entity49.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_49());
            entity49.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_49());
            entity49.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_49());
            entity49.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_49());
            entity49.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_49());
            entity49.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_49());
            entity49.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_49());
            entity49.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_49());
            entity49.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_49());
            entity49.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_49());
            世帯員所得情報List.add(entity49);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_50() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_50() != null) {
            SetaiShotokuEntity entity50 = new SetaiShotokuEntity();
            entity50.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_50());
            entity50.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_50());
            entity50.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_50());
            entity50.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_50());
            entity50.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_50());
            entity50.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_50());
            entity50.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_50());
            entity50.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_50());
            entity50.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_50());
            entity50.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_50());
            entity50.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_50());
            entity50.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_50());
            entity50.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_50());
            entity50.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_50());
            entity50.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_50());
            世帯員所得情報List.add(entity50);
        }
    }

    private void set世帯員所得情報_9(SetaiTempEntity 世帯員所得情報Entity, List<SetaiShotokuEntity> 世帯員所得情報List) {
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_42() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_42() != null) {
            SetaiShotokuEntity entity42 = new SetaiShotokuEntity();
            entity42.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_42());
            entity42.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_42());
            entity42.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_42());
            entity42.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_42());
            entity42.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_42());
            entity42.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_42());
            entity42.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_42());
            entity42.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_42());
            entity42.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_42());
            entity42.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_42());
            entity42.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_42());
            entity42.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_42());
            entity42.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_42());
            entity42.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_42());
            entity42.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_42());
            世帯員所得情報List.add(entity42);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_43() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_43() != null) {
            SetaiShotokuEntity entity43 = new SetaiShotokuEntity();
            entity43.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_43());
            entity43.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_43());
            entity43.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_43());
            entity43.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_43());
            entity43.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_43());
            entity43.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_43());
            entity43.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_43());
            entity43.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_43());
            entity43.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_43());
            entity43.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_43());
            entity43.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_43());
            entity43.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_43());
            entity43.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_43());
            entity43.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_43());
            entity43.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_43());
            世帯員所得情報List.add(entity43);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_44() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_44() != null) {
            SetaiShotokuEntity entity44 = new SetaiShotokuEntity();
            entity44.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_44());
            entity44.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_44());
            entity44.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_44());
            entity44.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_44());
            entity44.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_44());
            entity44.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_44());
            entity44.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_44());
            entity44.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_44());
            entity44.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_44());
            entity44.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_44());
            entity44.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_44());
            entity44.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_44());
            entity44.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_44());
            entity44.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_44());
            entity44.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_44());
            世帯員所得情報List.add(entity44);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_45() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_45() != null) {
            SetaiShotokuEntity entity45 = new SetaiShotokuEntity();
            entity45.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_45());
            entity45.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_45());
            entity45.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_45());
            entity45.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_45());
            entity45.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_45());
            entity45.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_45());
            entity45.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_45());
            entity45.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_45());
            entity45.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_45());
            entity45.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_45());
            entity45.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_45());
            entity45.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_45());
            entity45.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_45());
            entity45.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_45());
            entity45.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_45());
            世帯員所得情報List.add(entity45);
        }
    }

    private void set世帯員所得情報_8(SetaiTempEntity 世帯員所得情報Entity, List<SetaiShotokuEntity> 世帯員所得情報List) {
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_36() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_36() != null) {
            SetaiShotokuEntity entity36 = new SetaiShotokuEntity();
            entity36.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_36());
            entity36.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_36());
            entity36.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_36());
            entity36.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_36());
            entity36.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_36());
            entity36.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_36());
            entity36.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_36());
            entity36.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_36());
            entity36.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_36());
            entity36.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_36());
            entity36.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_36());
            entity36.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_36());
            entity36.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_36());
            entity36.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_36());
            entity36.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_36());
            世帯員所得情報List.add(entity36);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_37() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_37() != null) {
            SetaiShotokuEntity entity37 = new SetaiShotokuEntity();
            entity37.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_37());
            entity37.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_37());
            entity37.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_37());
            entity37.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_37());
            entity37.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_37());
            entity37.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_37());
            entity37.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_37());
            entity37.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_37());
            entity37.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_37());
            entity37.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_37());
            entity37.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_37());
            entity37.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_37());
            entity37.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_37());
            entity37.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_37());
            entity37.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_37());
            世帯員所得情報List.add(entity37);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_38() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_38() != null) {
            SetaiShotokuEntity entity38 = new SetaiShotokuEntity();
            entity38.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_38());
            entity38.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_38());
            entity38.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_38());
            entity38.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_38());
            entity38.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_38());
            entity38.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_38());
            entity38.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_38());
            entity38.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_38());
            entity38.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_38());
            entity38.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_38());
            entity38.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_38());
            entity38.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_38());
            entity38.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_38());
            entity38.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_38());
            entity38.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_38());
            世帯員所得情報List.add(entity38);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_39() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_39() != null) {
            SetaiShotokuEntity entity39 = new SetaiShotokuEntity();
            entity39.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_39());
            entity39.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_39());
            entity39.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_39());
            entity39.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_39());
            entity39.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_39());
            entity39.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_39());
            entity39.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_39());
            entity39.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_39());
            entity39.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_39());
            entity39.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_39());
            entity39.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_39());
            entity39.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_39());
            entity39.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_39());
            entity39.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_39());
            entity39.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_39());
            世帯員所得情報List.add(entity39);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_40() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_40() != null) {
            SetaiShotokuEntity entity40 = new SetaiShotokuEntity();
            entity40.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_40());
            entity40.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_40());
            entity40.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_40());
            entity40.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_40());
            entity40.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_40());
            entity40.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_40());
            entity40.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_40());
            entity40.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_40());
            entity40.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_40());
            entity40.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_40());
            entity40.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_40());
            entity40.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_40());
            entity40.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_40());
            entity40.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_40());
            entity40.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_40());
            世帯員所得情報List.add(entity40);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_41() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_41() != null) {
            SetaiShotokuEntity entity41 = new SetaiShotokuEntity();
            entity41.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_41());
            entity41.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_41());
            entity41.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_41());
            entity41.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_41());
            entity41.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_41());
            entity41.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_41());
            entity41.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_41());
            entity41.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_41());
            entity41.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_41());
            entity41.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_41());
            entity41.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_41());
            entity41.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_41());
            entity41.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_41());
            entity41.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_41());
            entity41.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_41());
            世帯員所得情報List.add(entity41);
        }
    }

    private void set世帯員所得情報_7(SetaiTempEntity 世帯員所得情報Entity, List<SetaiShotokuEntity> 世帯員所得情報List) {
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_31() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_31() != null) {
            SetaiShotokuEntity entity31 = new SetaiShotokuEntity();
            entity31.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_31());
            entity31.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_31());
            entity31.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_31());
            entity31.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_31());
            entity31.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_31());
            entity31.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_31());
            entity31.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_31());
            entity31.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_31());
            entity31.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_31());
            entity31.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_31());
            entity31.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_31());
            entity31.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_31());
            entity31.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_31());
            entity31.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_31());
            entity31.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_31());
            世帯員所得情報List.add(entity31);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_32() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_32() != null) {
            SetaiShotokuEntity entity32 = new SetaiShotokuEntity();
            entity32.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_32());
            entity32.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_32());
            entity32.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_32());
            entity32.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_32());
            entity32.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_32());
            entity32.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_32());
            entity32.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_32());
            entity32.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_32());
            entity32.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_32());
            entity32.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_32());
            entity32.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_32());
            entity32.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_32());
            entity32.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_32());
            entity32.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_32());
            entity32.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_32());
            世帯員所得情報List.add(entity32);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_33() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_33() != null) {
            SetaiShotokuEntity entity33 = new SetaiShotokuEntity();
            entity33.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_33());
            entity33.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_33());
            entity33.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_33());
            entity33.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_33());
            entity33.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_33());
            entity33.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_33());
            entity33.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_33());
            entity33.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_33());
            entity33.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_33());
            entity33.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_33());
            entity33.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_33());
            entity33.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_33());
            entity33.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_33());
            entity33.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_33());
            entity33.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_33());
            世帯員所得情報List.add(entity33);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_34() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_34() != null) {
            SetaiShotokuEntity entity34 = new SetaiShotokuEntity();
            entity34.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_34());
            entity34.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_34());
            entity34.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_34());
            entity34.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_34());
            entity34.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_34());
            entity34.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_34());
            entity34.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_34());
            entity34.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_34());
            entity34.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_34());
            entity34.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_34());
            entity34.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_34());
            entity34.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_34());
            entity34.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_34());
            entity34.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_34());
            entity34.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_34());
            世帯員所得情報List.add(entity34);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_35() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_35() != null) {
            SetaiShotokuEntity entity35 = new SetaiShotokuEntity();
            entity35.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_35());
            entity35.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_35());
            entity35.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_35());
            entity35.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_35());
            entity35.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_35());
            entity35.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_35());
            entity35.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_35());
            entity35.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_35());
            entity35.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_35());
            entity35.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_35());
            entity35.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_35());
            entity35.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_35());
            entity35.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_35());
            entity35.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_35());
            entity35.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_35());
            世帯員所得情報List.add(entity35);
        }
    }

    private void set世帯員所得情報_6(SetaiTempEntity 世帯員所得情報Entity, List<SetaiShotokuEntity> 世帯員所得情報List) {
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_26() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_26() != null) {
            SetaiShotokuEntity entity26 = new SetaiShotokuEntity();
            entity26.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_26());
            entity26.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_26());
            entity26.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_26());
            entity26.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_26());
            entity26.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_26());
            entity26.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_26());
            entity26.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_26());
            entity26.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_26());
            entity26.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_26());
            entity26.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_26());
            entity26.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_26());
            entity26.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_26());
            entity26.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_26());
            entity26.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_26());
            entity26.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_26());
            世帯員所得情報List.add(entity26);
        }

        if (世帯員所得情報Entity.getSetai_hihokenshaNo_27() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_27() != null) {
            SetaiShotokuEntity entity27 = new SetaiShotokuEntity();
            entity27.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_27());
            entity27.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_27());
            entity27.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_27());
            entity27.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_27());
            entity27.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_27());
            entity27.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_27());
            entity27.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_27());
            entity27.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_27());
            entity27.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_27());
            entity27.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_27());
            entity27.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_27());
            entity27.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_27());
            entity27.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_27());
            entity27.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_27());
            entity27.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_27());
            世帯員所得情報List.add(entity27);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_28() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_28() != null) {
            SetaiShotokuEntity entity28 = new SetaiShotokuEntity();
            entity28.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_28());
            entity28.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_28());
            entity28.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_28());
            entity28.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_28());
            entity28.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_28());
            entity28.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_28());
            entity28.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_28());
            entity28.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_28());
            entity28.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_28());
            entity28.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_28());
            entity28.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_28());
            entity28.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_28());
            entity28.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_28());
            entity28.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_28());
            entity28.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_28());
            世帯員所得情報List.add(entity28);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_29() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_29() != null) {
            SetaiShotokuEntity entity29 = new SetaiShotokuEntity();
            entity29.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_29());
            entity29.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_29());
            entity29.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_29());
            entity29.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_29());
            entity29.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_29());
            entity29.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_29());
            entity29.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_29());
            entity29.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_29());
            entity29.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_29());
            entity29.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_29());
            entity29.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_29());
            entity29.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_29());
            entity29.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_29());
            entity29.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_29());
            entity29.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_29());
            世帯員所得情報List.add(entity29);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_30() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_30() != null) {
            SetaiShotokuEntity entity30 = new SetaiShotokuEntity();
            entity30.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_30());
            entity30.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_30());
            entity30.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_30());
            entity30.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_30());
            entity30.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_30());
            entity30.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_30());
            entity30.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_30());
            entity30.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_30());
            entity30.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_30());
            entity30.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_30());
            entity30.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_30());
            entity30.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_30());
            entity30.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_30());
            entity30.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_30());
            entity30.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_30());
            世帯員所得情報List.add(entity30);
        }
    }

    private void set世帯員所得情報_5(SetaiTempEntity 世帯員所得情報Entity, List<SetaiShotokuEntity> 世帯員所得情報List) {
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_21() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_21() != null) {
            SetaiShotokuEntity entity21 = new SetaiShotokuEntity();
            entity21.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_21());
            entity21.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_21());
            entity21.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_21());
            entity21.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_21());
            entity21.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_21());
            entity21.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_21());
            entity21.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_21());
            entity21.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_21());
            entity21.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_21());
            entity21.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_21());
            entity21.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_21());
            entity21.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_21());
            entity21.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_21());
            entity21.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_21());
            entity21.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_21());
            世帯員所得情報List.add(entity21);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_22() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_22() != null) {
            SetaiShotokuEntity entity22 = new SetaiShotokuEntity();
            entity22.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_22());
            entity22.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_22());
            entity22.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_22());
            entity22.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_22());
            entity22.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_22());
            entity22.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_22());
            entity22.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_22());
            entity22.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_22());
            entity22.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_22());
            entity22.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_22());
            entity22.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_22());
            entity22.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_22());
            entity22.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_22());
            entity22.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_22());
            entity22.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_22());
            世帯員所得情報List.add(entity22);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_23() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_23() != null) {
            SetaiShotokuEntity entity23 = new SetaiShotokuEntity();
            entity23.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_23());
            entity23.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_23());
            entity23.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_23());
            entity23.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_23());
            entity23.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_23());
            entity23.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_23());
            entity23.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_23());
            entity23.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_23());
            entity23.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_23());
            entity23.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_23());
            entity23.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_23());
            entity23.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_23());
            entity23.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_23());
            entity23.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_23());
            entity23.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_23());
            世帯員所得情報List.add(entity23);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_24() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_24() != null) {
            SetaiShotokuEntity entity24 = new SetaiShotokuEntity();
            entity24.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_24());
            entity24.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_24());
            entity24.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_24());
            entity24.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_24());
            entity24.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_24());
            entity24.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_24());
            entity24.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_24());
            entity24.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_24());
            entity24.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_24());
            entity24.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_24());
            entity24.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_24());
            entity24.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_24());
            entity24.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_24());
            entity24.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_24());
            entity24.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_24());
            世帯員所得情報List.add(entity24);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_25() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_25() != null) {
            SetaiShotokuEntity entity25 = new SetaiShotokuEntity();
            entity25.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_25());
            entity25.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_25());
            entity25.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_25());
            entity25.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_25());
            entity25.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_25());
            entity25.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_25());
            entity25.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_25());
            entity25.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_25());
            entity25.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_25());
            entity25.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_25());
            entity25.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_25());
            entity25.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_25());
            entity25.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_25());
            entity25.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_25());
            entity25.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_25());
            世帯員所得情報List.add(entity25);
        }
    }

    private void set世帯員所得情報_4(SetaiTempEntity 世帯員所得情報Entity, List<SetaiShotokuEntity> 世帯員所得情報List) {
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_16() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_16() != null) {
            SetaiShotokuEntity entity16 = new SetaiShotokuEntity();
            entity16.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_16());
            entity16.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_16());
            entity16.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_16());
            entity16.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_16());
            entity16.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_16());
            entity16.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_16());
            entity16.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_16());
            entity16.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_16());
            entity16.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_16());
            entity16.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_16());
            entity16.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_16());
            entity16.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_16());
            entity16.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_16());
            entity16.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_16());
            entity16.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_16());
            世帯員所得情報List.add(entity16);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_17() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_17() != null) {
            SetaiShotokuEntity entity17 = new SetaiShotokuEntity();
            entity17.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_17());
            entity17.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_17());
            entity17.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_17());
            entity17.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_17());
            entity17.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_17());
            entity17.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_17());
            entity17.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_17());
            entity17.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_17());
            entity17.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_17());
            entity17.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_17());
            entity17.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_17());
            entity17.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_17());
            entity17.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_17());
            entity17.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_17());
            entity17.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_17());
            世帯員所得情報List.add(entity17);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_18() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_18() != null) {
            SetaiShotokuEntity entity18 = new SetaiShotokuEntity();
            entity18.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_18());
            entity18.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_18());
            entity18.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_18());
            entity18.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_18());
            entity18.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_18());
            entity18.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_18());
            entity18.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_18());
            entity18.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_18());
            entity18.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_18());
            entity18.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_18());
            entity18.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_18());
            entity18.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_18());
            entity18.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_18());
            entity18.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_18());
            entity18.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_18());
            世帯員所得情報List.add(entity18);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_19() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_19() != null) {
            SetaiShotokuEntity entity19 = new SetaiShotokuEntity();
            entity19.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_19());
            entity19.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_19());
            entity19.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_19());
            entity19.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_19());
            entity19.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_19());
            entity19.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_19());
            entity19.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_19());
            entity19.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_19());
            entity19.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_19());
            entity19.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_19());
            entity19.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_19());
            entity19.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_19());
            entity19.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_19());
            entity19.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_19());
            entity19.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_19());
            世帯員所得情報List.add(entity19);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_20() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_20() != null) {
            SetaiShotokuEntity entity20 = new SetaiShotokuEntity();
            entity20.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_20());
            entity20.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_20());
            entity20.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_20());
            entity20.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_20());
            entity20.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_20());
            entity20.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_20());
            entity20.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_20());
            entity20.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_20());
            entity20.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_20());
            entity20.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_20());
            entity20.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_20());
            entity20.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_20());
            entity20.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_20());
            entity20.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_20());
            entity20.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_20());
            世帯員所得情報List.add(entity20);
        }
    }

    private void set世帯員所得情報_3(SetaiTempEntity 世帯員所得情報Entity, List<SetaiShotokuEntity> 世帯員所得情報List) {
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_11() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_11() != null) {
            SetaiShotokuEntity entity11 = new SetaiShotokuEntity();
            entity11.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_11());
            entity11.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_11());
            entity11.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_11());
            entity11.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_11());
            entity11.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_11());
            entity11.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_11());
            entity11.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_11());
            entity11.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_11());
            entity11.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_11());
            entity11.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_11());
            entity11.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_11());
            entity11.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_11());
            entity11.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_11());
            entity11.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_11());
            entity11.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_11());
            世帯員所得情報List.add(entity11);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_12() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_12() != null) {
            SetaiShotokuEntity entity12 = new SetaiShotokuEntity();
            entity12.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_12());
            entity12.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_12());
            entity12.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_12());
            entity12.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_12());
            entity12.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_12());
            entity12.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_12());
            entity12.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_12());
            entity12.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_12());
            entity12.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_12());
            entity12.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_12());
            entity12.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_12());
            entity12.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_12());
            entity12.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_12());
            entity12.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_12());
            entity12.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_12());
            世帯員所得情報List.add(entity12);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_13() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_13() != null) {
            SetaiShotokuEntity entity13 = new SetaiShotokuEntity();
            entity13.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_13());
            entity13.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_13());
            entity13.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_13());
            entity13.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_13());
            entity13.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_13());
            entity13.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_13());
            entity13.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_13());
            entity13.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_13());
            entity13.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_13());
            entity13.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_13());
            entity13.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_13());
            entity13.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_13());
            entity13.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_13());
            entity13.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_13());
            entity13.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_13());
            世帯員所得情報List.add(entity13);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_14() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_14() != null) {
            SetaiShotokuEntity entity14 = new SetaiShotokuEntity();
            entity14.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_14());
            entity14.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_14());
            entity14.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_14());
            entity14.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_14());
            entity14.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_14());
            entity14.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_14());
            entity14.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_14());
            entity14.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_14());
            entity14.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_14());
            entity14.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_14());
            entity14.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_14());
            entity14.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_14());
            entity14.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_14());
            entity14.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_14());
            entity14.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_14());
            世帯員所得情報List.add(entity14);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_15() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_15() != null) {
            SetaiShotokuEntity entity15 = new SetaiShotokuEntity();
            entity15.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_15());
            entity15.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_15());
            entity15.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_15());
            entity15.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_15());
            entity15.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_15());
            entity15.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_15());
            entity15.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_15());
            entity15.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_15());
            entity15.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_15());
            entity15.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_15());
            entity15.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_15());
            entity15.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_15());
            entity15.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_15());
            entity15.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_15());
            entity15.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_15());
            世帯員所得情報List.add(entity15);
        }
    }

    private void set世帯員所得情報_2(SetaiTempEntity 世帯員所得情報Entity, List<SetaiShotokuEntity> 世帯員所得情報List) {
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_6() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_6() != null) {
            SetaiShotokuEntity entity6 = new SetaiShotokuEntity();
            entity6.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_6());
            entity6.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_6());
            entity6.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_6());
            entity6.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_6());
            entity6.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_6());
            entity6.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_6());
            entity6.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_6());
            entity6.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_6());
            entity6.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_6());
            entity6.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_6());
            entity6.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_6());
            entity6.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_6());
            entity6.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_6());
            entity6.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_6());
            entity6.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_6());
            世帯員所得情報List.add(entity6);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_7() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_7() != null) {
            SetaiShotokuEntity entity7 = new SetaiShotokuEntity();
            entity7.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_7());
            entity7.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_7());
            entity7.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_7());
            entity7.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_7());
            entity7.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_7());
            entity7.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_7());
            entity7.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_7());
            entity7.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_7());
            entity7.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_7());
            entity7.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_7());
            entity7.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_7());
            entity7.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_7());
            entity7.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_7());
            entity7.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_7());
            entity7.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_7());
            世帯員所得情報List.add(entity7);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_8() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_8() != null) {
            SetaiShotokuEntity entity8 = new SetaiShotokuEntity();
            entity8.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_8());
            entity8.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_8());
            entity8.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_8());
            entity8.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_8());
            entity8.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_8());
            entity8.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_8());
            entity8.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_8());
            entity8.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_8());
            entity8.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_8());
            entity8.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_8());
            entity8.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_8());
            entity8.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_8());
            entity8.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_8());
            entity8.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_8());
            entity8.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_8());
            世帯員所得情報List.add(entity8);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_9() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_9() != null) {
            SetaiShotokuEntity entity9 = new SetaiShotokuEntity();
            entity9.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_9());
            entity9.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_9());
            entity9.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_9());
            entity9.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_9());
            entity9.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_9());
            entity9.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_9());
            entity9.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_9());
            entity9.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_9());
            entity9.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_9());
            entity9.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_9());
            entity9.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_9());
            entity9.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_9());
            entity9.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_9());
            entity9.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_9());
            entity9.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_9());
            世帯員所得情報List.add(entity9);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_10() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_10() != null) {
            SetaiShotokuEntity entity10 = new SetaiShotokuEntity();
            entity10.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_10());
            entity10.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_10());
            entity10.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_10());
            entity10.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_10());
            entity10.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_10());
            entity10.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_10());
            entity10.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_10());
            entity10.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_10());
            entity10.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_10());
            entity10.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_10());
            entity10.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_10());
            entity10.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_10());
            entity10.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_10());
            entity10.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_10());
            entity10.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_10());
            世帯員所得情報List.add(entity10);
        }
    }

    private void set世帯員所得情報_1(SetaiTempEntity 世帯員所得情報Entity, List<SetaiShotokuEntity> 世帯員所得情報List) {
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_1() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_1() != null) {
            SetaiShotokuEntity entity1 = new SetaiShotokuEntity();
            entity1.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_1());
            entity1.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_1());
            entity1.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_1());
            entity1.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_1());
            entity1.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_1());
            entity1.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_1());
            entity1.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_1());
            entity1.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_1());
            entity1.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_1());
            entity1.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_1());
            entity1.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_1());
            entity1.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_1());
            entity1.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_1());
            entity1.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_1());
            entity1.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_1());
            世帯員所得情報List.add(entity1);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_2() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_2() != null) {
            SetaiShotokuEntity entity2 = new SetaiShotokuEntity();
            entity2.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_2());
            entity2.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_2());
            entity2.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_2());
            entity2.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_2());
            entity2.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_2());
            entity2.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_2());
            entity2.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_2());
            entity2.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_2());
            entity2.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_2());
            entity2.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_2());
            entity2.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_2());
            entity2.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_2());
            entity2.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_2());
            entity2.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_2());
            entity2.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_2());
            世帯員所得情報List.add(entity2);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_3() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_3() != null) {
            SetaiShotokuEntity entity3 = new SetaiShotokuEntity();
            entity3.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_3());
            entity3.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_3());
            entity3.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_3());
            entity3.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_3());
            entity3.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_3());
            entity3.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_3());
            entity3.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_3());
            entity3.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_3());
            entity3.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_3());
            entity3.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_3());
            entity3.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_3());
            entity3.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_3());
            entity3.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_3());
            entity3.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_3());
            entity3.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_3());
            世帯員所得情報List.add(entity3);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_4() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_4() != null) {
            SetaiShotokuEntity entity4 = new SetaiShotokuEntity();
            entity4.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_4());
            entity4.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_4());
            entity4.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_4());
            entity4.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_4());
            entity4.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_4());
            entity4.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_4());
            entity4.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_4());
            entity4.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_4());
            entity4.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_4());
            entity4.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_4());
            entity4.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_4());
            entity4.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_4());
            entity4.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_4());
            entity4.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_4());
            entity4.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_4());
            世帯員所得情報List.add(entity4);
        }
        if (世帯員所得情報Entity.getSetai_hihokenshaNo_5() != null && 世帯員所得情報Entity.getSetai_shikibetsuCode_5() != null) {
            SetaiShotokuEntity entity5 = new SetaiShotokuEntity();
            entity5.setHihokenshaNo(世帯員所得情報Entity.getSetai_hihokenshaNo_5());
            entity5.setShikibetsuCode(世帯員所得情報Entity.getSetai_shikibetsuCode_5());
            entity5.setKijunYMD(世帯員所得情報Entity.getSetai_kijunYMD_5());
            entity5.setShotokuNendo(世帯員所得情報Entity.getSetai_shotokuNendo_5());
            entity5.setJushochiTokureiFlag(世帯員所得情報Entity.getSetai_jushochiTokureiFlag_5());
            entity5.setSetaiCode(世帯員所得情報Entity.getSetai_setaiCode_5());
            entity5.setHonninKubun(世帯員所得情報Entity.getSetai_honninKubun_5());
            entity5.setKazeiKubun(世帯員所得情報Entity.getSetai_kazeiKubun_5());
            entity5.setKazeiKubunGemmenGo(世帯員所得情報Entity.getSetai_kazeiKubunGemmenGo_5());
            entity5.setGekihenKanwaKubun(世帯員所得情報Entity.getSetai_gekihenKanwaKubun_5());
            entity5.setGokeiShotokuGaku(世帯員所得情報Entity.getSetai_gokeiShotokuGaku_5());
            entity5.setNenkiniShunyuGaku(世帯員所得情報Entity.getSetai_nenkiniShunyuGaku_5());
            entity5.setNenkiniShotokuGaku(世帯員所得情報Entity.getSetai_nenkiniShotokuGaku_5());
            entity5.setKazeiShotokuGaku(世帯員所得情報Entity.getSetai_kazeiShotokuGaku_5());
            entity5.setTorokuGyomu(世帯員所得情報Entity.getSetai_torokuGyomu_5());
            世帯員所得情報List.add(entity5);
        }
    }
}
