/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.seikatsuHogoJoho;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dba.business.core.seikatsuHogoJoho.SeikatsuFujyoShubetsuJoho;
import jp.co.ndensan.reams.db.dba.business.core.seikatsuHogoJoho.SeikatsuJukyuShaJoho;
import jp.co.ndensan.reams.db.dba.business.core.seikatsuHogoJoho.SeikatsuTeishiJoho;
import jp.co.ndensan.reams.db.dba.business.core.seikatsuHogoJoho.SeikatsuTorokuJoho;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.seikatsuHogoJoho.SeikatsuHogoJohoTorokuMyBatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.seikatsuHogoJoho.SeikatsuHogoJohoTorokuEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.seikatsuhogo.ISeikatsuHogoJohoTorokuMapper;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0526SeikatsuHogoFujoShuruiEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0528SeikatsuHogoTeishikikanEntity;
import jp.co.ndensan.reams.ur.urz.persistence.db.mapper.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 生活保護情報登録情報を 取得します。
 *
 * @reamsid_L URU-5640-030 zhuxiaojun
 */
public class SeikatsuHogoJohoTorukuManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public SeikatsuHogoJohoTorukuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);

    }

    /**
     * SeikatsuHogoJohoTorukuManagerのインスタンスです。
     *
     * @return SeikatsuHogoJohoTorukuManager
     */
    public static SeikatsuHogoJohoTorukuManager createInstance() {
        return InstanceProvider.create(SeikatsuHogoJohoTorukuManager.class);
    }

    /**
     * 生活保護情報登録リストを取得します。
     *
     * @param shikibetsuCode 識別コード
     * @param gyomuCode 業務コード
     *
     * @return 生活保護情報登録リスト
     */
    @Transaction
    public List<SeikatsuTorokuJoho> get生活保護情報登録リスト(RString shikibetsuCode, RString gyomuCode) {
        ISeikatsuHogoJohoTorokuMapper mapper = mapperProvider.create(ISeikatsuHogoJohoTorokuMapper.class);
        List<SeikatsuHogoJohoTorokuEntity> seikatsuList = mapper.get生活保護情報登録リスト(SeikatsuHogoJohoTorokuMyBatisParameter
                .createSelectByKeyParameter(shikibetsuCode, RString.EMPTY, gyomuCode));
        if (!seikatsuList.isEmpty()) {
            List<UrT0508SeikatsuHogoJukyushaEntity> jukyushaList = get生活保護受給者リスト(seikatsuList.get(0).get生活保護受給者リスト());
            List<UrT0526SeikatsuHogoFujoShuruiEntity> fujyoList = get扶助種別リスト(seikatsuList.get(0).get扶助種別リスト());
            List<UrT0528SeikatsuHogoTeishikikanEntity> teikikanList = get停止期間リスト(seikatsuList.get(0).get停止期間リスト());
            return 対象取得処理(jukyushaList, fujyoList, teikikanList);
        }
        return null;
    }




    private List<UrT0508SeikatsuHogoJukyushaEntity> get生活保護受給者リスト(List<UrT0508SeikatsuHogoJukyushaEntity> seikatsuList) {
        Set jufu = new HashSet();
        List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者リスト = new ArrayList<>();
        int length = seikatsuList.size();
        for (int i = 0; i < seikatsuList.size() - 1; i++) {
            for (int j = i + 1; j < seikatsuList.size(); j++) {
                if (seikatsuList.get(i).getShikibetsuCode().equals(seikatsuList.get(j).getShikibetsuCode())
                        && seikatsuList.get(i).getGyomuCode().equals(seikatsuList.get(j).getGyomuCode())
                        && seikatsuList.get(i).getJukyuKaishiYMD().equals(seikatsuList.get(j).getJukyuKaishiYMD())
                        && !jufu.contains(i)) {
                    jufu.add(j);
                }
            }
        }
        for (int k = 0; k < length; k++) {
            if (!jufu.contains(k)) {
                生活保護受給者リスト.add(seikatsuList.get(k));
            }
        }
        return 生活保護受給者リスト;
    }

    private List<UrT0526SeikatsuHogoFujoShuruiEntity> get扶助種別リスト(List<UrT0526SeikatsuHogoFujoShuruiEntity> fujyoList) {
        Set jufu = new HashSet();
        List<UrT0526SeikatsuHogoFujoShuruiEntity> 扶助種別リスト = new ArrayList<>();
        for (int i = 0; i < fujyoList.size() - 1; i++) {
            for (int j = i + 1; j < fujyoList.size(); j++) {
                if (fujyoList.get(i).getShikibetsuCode().equals(fujyoList.get(j).getShikibetsuCode())
                        && fujyoList.get(i).getGyomuCode().equals(fujyoList.get(j).getGyomuCode())
                        && fujyoList.get(i).getJukyuKaishiYMD().equals(fujyoList.get(j).getJukyuKaishiYMD())
                        && fujyoList.get(i).getFujoShuruiCode().value().equals(fujyoList.get(j).getFujoShuruiCode().value())
                        && !jufu.contains(i)) {
                    jufu.add(j);
                }
            }
        }
        for (int k = 0; k < fujyoList.size(); k++) {
            if (!jufu.contains(k)) {
                扶助種別リスト.add(fujyoList.get(k));
            }
        }
        return 扶助種別リスト;
    }

    private List<UrT0528SeikatsuHogoTeishikikanEntity> removeKaishiNull(List<UrT0528SeikatsuHogoTeishikikanEntity> seikatsuList) {
        List<UrT0528SeikatsuHogoTeishikikanEntity> teishikikanList = new ArrayList<>();
        for (int i = 0; i < seikatsuList.size(); i++) {
            if (seikatsuList.get(i).getJukyuTeishiKaishiYMD() != null) {
                teishikikanList.add(seikatsuList.get(i));
            }
        }
        return teishikikanList;
    }

    private List<UrT0528SeikatsuHogoTeishikikanEntity> getTeishikikan(List<UrT0528SeikatsuHogoTeishikikanEntity> seikatsuList, Set jufu) {
        List<UrT0528SeikatsuHogoTeishikikanEntity> teishikikanList = new ArrayList<>();
        for (int k = 0; k < seikatsuList.size(); k++) {
            if (!jufu.contains(k)) {
                teishikikanList.add(seikatsuList.get(k));
            }
        }
        return teishikikanList;
    }

    private List<UrT0528SeikatsuHogoTeishikikanEntity> get停止期間リスト(List<UrT0528SeikatsuHogoTeishikikanEntity> teishikikanList) {
        Set jufu = new HashSet();
        teishikikanList = removeKaishiNull(teishikikanList);
        for (int i = 0; i < teishikikanList.size() - 1; i++) {
            for (int j = i + 1; j < teishikikanList.size(); j++) {
                if (teishikikanList.get(i).getShikibetsuCode().equals(teishikikanList.get(j).getShikibetsuCode())
                        && teishikikanList.get(i).getGyomuCode().equals(teishikikanList.get(j).getGyomuCode())
                        && teishikikanList.get(i).getJukyuKaishiYMD().equals(teishikikanList.get(j).getJukyuKaishiYMD())
                        && teishikikanList.get(i).getJukyuTeishiShuryoYMD() == null
                        && teishikikanList.get(j).getJukyuTeishiShuryoYMD() == null) {
                    jufu.add(j);
                }
                if (teishikikanList.get(i).getShikibetsuCode().equals(teishikikanList.get(j).getShikibetsuCode())
                        && teishikikanList.get(i).getGyomuCode().equals(teishikikanList.get(j).getGyomuCode())
                        && teishikikanList.get(i).getJukyuKaishiYMD().equals(teishikikanList.get(j).getJukyuKaishiYMD())
                        && (teishikikanList.get(i).getJukyuTeishiKaishiYMD() != null
                        || teishikikanList.get(j).getJukyuTeishiKaishiYMD() != null)
                        && teishikikanList.get(i).getJukyuTeishiKaishiYMD().equals(teishikikanList.get(j).getJukyuTeishiKaishiYMD())
                        && (teishikikanList.get(i).getJukyuTeishiShuryoYMD() != null
                        || teishikikanList.get(j).getJukyuTeishiShuryoYMD() != null)
                        && teishikikanList.get(i).getJukyuTeishiShuryoYMD().equals(teishikikanList.get(j).getJukyuTeishiShuryoYMD())
                        && !jufu.contains(i)) {
                    jufu.add(j);
                }
            }
        }
        return getTeishikikan(teishikikanList, jufu);
    }

    private List<SeikatsuTorokuJoho> 対象取得処理(List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者,
            List<UrT0526SeikatsuHogoFujoShuruiEntity> 扶助種別リスト,
            List<UrT0528SeikatsuHogoTeishikikanEntity> 停止期間リスト) {
        List<SeikatsuFujyoShubetsuJoho> fujyoList;
        List<SeikatsuTeishiJoho> teishiList;
        List<SeikatsuTorokuJoho> seikatsuJoho = new ArrayList<>();
        for (UrT0508SeikatsuHogoJukyushaEntity jukyushaEntity : 生活保護受給者) {
            SeikatsuTorokuJoho joho = new SeikatsuTorokuJoho();
            fujyoList = new ArrayList<>();
            teishiList = new ArrayList<>();
            joho.set生活保護受給者(new SeikatsuJukyuShaJoho(jukyushaEntity));
            for (UrT0526SeikatsuHogoFujoShuruiEntity fujyoEntity : 扶助種別リスト) {
                if (jukyushaEntity.getJukyuKaishiYMD().equals(fujyoEntity.getJukyuKaishiYMD())
                        && jukyushaEntity.getGyomuCode().equals(fujyoEntity.getGyomuCode())
                        && jukyushaEntity.getShikibetsuCode().equals(fujyoEntity.getShikibetsuCode())
                        && fujyoEntity.getFujoShuruiCode() != null) {
                    fujyoList.add(new SeikatsuFujyoShubetsuJoho(fujyoEntity));

                }
            }
            joho.set扶助種別リスト(fujyoList);
            for (UrT0528SeikatsuHogoTeishikikanEntity teishiEntity : 停止期間リスト) {
                if (jukyushaEntity.getJukyuKaishiYMD().equals(teishiEntity.getJukyuKaishiYMD())
                        && jukyushaEntity.getGyomuCode().equals(teishiEntity.getGyomuCode())
                        && jukyushaEntity.getShikibetsuCode().equals(teishiEntity.getShikibetsuCode())
                        && !(teishiEntity.getJukyuTeishiKaishiYMD() == null && teishiEntity.getJukyuTeishiShuryoYMD() == null)) {
                    teishiList.add(new SeikatsuTeishiJoho(teishiEntity));
                }
            }
            joho.set停止期間リスト(teishiList);
            seikatsuJoho.add(joho);
        }
        return seikatsuJoho;
    }
}
