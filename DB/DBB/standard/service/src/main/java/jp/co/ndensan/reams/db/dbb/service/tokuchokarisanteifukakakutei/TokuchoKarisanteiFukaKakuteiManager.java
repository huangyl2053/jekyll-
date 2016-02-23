/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.tokuchokarisanteifukakakutei;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.relate.tokuchokarisanteifukakakutei.TokuchoKarisanteiFukaKakuteiMapperParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic.tokuchokarisanteifukakakutei.ItokuchokarisanteiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.IAssociation;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 特徴仮算定賦課確定のクラスです
 */
public class TokuchoKarisanteiFukaKakuteiManager {

    private final DbT7022ShoriDateKanriDac 介護賦課Dac;
    private static final RString 最大年度内連番 = new RString("0001");
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     *
     */
    public TokuchoKarisanteiFukaKakuteiManager() {
        this.介護賦課Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param DbT7022ShoriDateKanriDac 介護賦課Dac
     * @param MapperProvider mapperProvider
     */
    TokuchoKarisanteiFukaKakuteiManager(DbT7022ShoriDateKanriDac 介護賦課Dac, MapperProvider mapperProvider) {
        this.介護賦課Dac = 介護賦課Dac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokuchoKarisanteiFukaKakuteiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TokuchoKarisanteiFukaKakuteiManager}のインスタンス
     */
    public static TokuchoKarisanteiFukaKakuteiManager createInstance() {
        return InstanceProvider.create(TokuchoKarisanteiFukaKakuteiManager.class);
    }

    /**
     * 処理日付管理マスタ.基準日時を取得します。
     *
     * @param 賦課年度 FlexibleYear
     * @param 処理名 処理名
     * @return 基準日時
     */
    @Transaction
    public FlexibleDate getKijunDateTime(FlexibleYear 賦課年度, RString 処理名) {
        DbT7022ShoriDateKanriEntity 基準日時 = 介護賦課Dac.selectKaijun(賦課年度, 処理名);
        if (基準日時 != null) {
            return (基準日時.getKijunYMD());
        } else {
            return null;
        }
    }

    /**
     * 処理日付管理マスタ.基準日時を更新します。
     *
     * @param 賦課年度 FlexibleYear
     * @param 処理名 処理名
     * @return 基準日時
     */
    @Transaction
    public int updateKijunDateTime(FlexibleYear 賦課年度, RString 処理名) {
        if (処理名.equals(ShoriName.特徴仮算定賦課確定.get名称())
                || 処理名.equals(ShoriName.普徴仮算定賦課確定.get名称()) || 処理名.equals(ShoriName.本算定賦課確定.get名称())) {
            DbT7022ShoriDateKanriEntity 基準日時 = 介護賦課Dac.selectKaijun_検索(賦課年度, 処理名);
            基準日時.setKijunYMD(new FlexibleDate(RDate.getNowDate().toDateString()));
            基準日時.setState(EntityDataState.Modified);
            return 介護賦課Dac.save(基準日時);
        }
        return insertKijunDateTime_登録(賦課年度, 処理名);
    }

    @Transaction
    private int insertKijunDateTime_登録(FlexibleYear 賦課年度, RString 処理名) {
        if (処理名.equals(ShoriName.仮算定異動賦課確定.get名称()) || 処理名.equals(ShoriName.異動賦課確定.get名称())) {
            DbT7022ShoriDateKanriEntity 登録_処理 = 介護賦課Dac.selectKaijun_処理(賦課年度, 処理名);
            if (登録_処理 == null) {
                登録_処理.setNendoNaiRenban(最大年度内連番);
            } else {
                登録_処理.setNendoNaiRenban(
                        new RString(String.valueOf(Integer.valueOf(登録_処理.getNendoNaiRenban().toString()) + 1)).padZeroToLeft(4));
            }
            IAssociation association = AssociationFinderFactory.createInstance().getAssociation();
            登録_処理.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
            登録_処理.setShichosonCode(association.get地方公共団体コード());
            登録_処理.setShoriName(処理名);
            登録_処理.setNendo(賦課年度);
            登録_処理.setShoriEdaban(最大年度内連番);
            登録_処理.setKijunYMD(new FlexibleDate(RDate.getNowDate().toDateString()));
            登録_処理.setKijunTimestamp(new YMDHMS(RDate.getNowDateTime()));
            登録_処理.setState(EntityDataState.Added);
            return 介護賦課Dac.save(登録_処理);
        }
        return 0;
    }

    /**
     * 調定共通（介護継承）.賦課処理状況を更新します。
     *
     * @param params　TokuchoKarisanteiFukaKakutei
     * @return 基準日時
     */
    @Transaction
    // TODO  内部QA：540 (賦課処理状況を更新)
    public boolean updateFukaShoriJyokyo(TokuchoKarisanteiFukaKakuteiMapperParameter params) {
        ItokuchokarisanteiMapper ItokuchokarisanteiMapper = mapperProvider.create(ItokuchokarisanteiMapper.class);
        return ItokuchokarisanteiMapper.updShoKofuKaishuJoho(params);
    }
}
