/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.nenreitotatsushikakuidochoshuhohokoshin;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.nenreitotatsushikakuidochoshuhohokoshin.NenreitotatsuShikakuIdoChoshuhohoKoshinMybatisParam;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2001ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbV2001ChoshuHohoAliveDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.nenreitotatsushikakuidochoshuhohokoshin.INenreitotatsuShikakuIdoChoshuhohoKoshinMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.choshuhoho.ChoshuHohoKoshin;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * ６５歳年齢到達資格異動徴収方法更新
 *
 * @reamsid_L DBB-9210-010 xuhao
 */
public class NenreitotatsuShikakuIdoChoshuhohoKoshin {

    private static final SubGyomuCode サブ業務コード = SubGyomuCode.DBA介護資格;
    private static final LasdecCode 市町村コード = new LasdecCode("000000");
    private static final RString 処理名 = new RString("年齢到達抽出処理");
    private static final RString 処理枝番 = new RString("00");
    private static final FlexibleYear 年度 = new FlexibleYear("0000");
    private static final RString 年度内連番 = new RString("00");
    private static final RString CODE = new RString("31");
    private final DbT7022ShoriDateKanriDac shoriDateKanriDac;
    private final DbV2001ChoshuHohoAliveDac choshuHohoAliveDac;
    private final ChoshuHohoKoshin choshuHohoKoshin;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public NenreitotatsuShikakuIdoChoshuhohoKoshin() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        shoriDateKanriDac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        choshuHohoAliveDac = InstanceProvider.create(DbV2001ChoshuHohoAliveDac.class);
        choshuHohoKoshin = InstanceProvider.create(ChoshuHohoKoshin.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param shoriDateKanriDac shoriDateKanriDac
     * @param choshuHohoAliveDac choshuHohoAliveDac
     * @param choshuHohoKoshin choshuHohoKoshin
     * @param choshuHoho choshuHoho
     */
    NenreitotatsuShikakuIdoChoshuhohoKoshin(
            MapperProvider mapperProvider,
            DbT7022ShoriDateKanriDac shoriDateKanriDac,
            DbV2001ChoshuHohoAliveDac choshuHohoAliveDac,
            ChoshuHohoKoshin choshuHohoKoshin
    ) {
        this.mapperProvider = mapperProvider;
        this.shoriDateKanriDac = shoriDateKanriDac;
        this.choshuHohoAliveDac = choshuHohoAliveDac;
        this.choshuHohoKoshin = choshuHohoKoshin;
    }

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link}のインスタンス
     */
    public static NenreitotatsuShikakuIdoChoshuhohoKoshin createInstance() {
        return InstanceProvider.create(NenreitotatsuShikakuIdoChoshuhohoKoshin.class);
    }

    /**
     * 徴収方法テーブル更新
     *
     * @param 徴収方法の情報 ChoshuHoho
     */
    @Transaction
    public void upd徴収方法テーブル更新(ChoshuHoho 徴収方法の情報) {
        DbT2001ChoshuHohoDac 徴収方法Dac = InstanceProvider.create(DbT2001ChoshuHohoDac.class);
        DbT2001ChoshuHohoEntity entity = new DbT2001ChoshuHohoEntity();
        entity.setFukaNendo(徴収方法の情報.toEntity().getFukaNendo());
        entity.setHihokenshaNo(徴収方法の情報.toEntity().getHihokenshaNo());
        entity.setRirekiNo(徴収方法の情報.toEntity().getRirekiNo() + 1);
        entity.setChoshuHoho4gatsu(徴収方法の情報.toEntity().getChoshuHoho4gatsu());
        entity.setChoshuHoho5gatsu(徴収方法の情報.toEntity().getChoshuHoho5gatsu());
        entity.setChoshuHoho6gatsu(徴収方法の情報.toEntity().getChoshuHoho6gatsu());
        entity.setChoshuHoho7gatsu(徴収方法の情報.toEntity().getChoshuHoho7gatsu());
        entity.setChoshuHoho8gatsu(徴収方法の情報.toEntity().getChoshuHoho8gatsu());
        entity.setChoshuHoho9gatsu(徴収方法の情報.toEntity().getChoshuHoho9gatsu());
        entity.setChoshuHoho10gatsu(徴収方法の情報.toEntity().getChoshuHoho10gatsu());
        entity.setChoshuHoho11gatsu(徴収方法の情報.toEntity().getChoshuHoho11gatsu());
        entity.setChoshuHoho12gatsu(徴収方法の情報.toEntity().getChoshuHoho12gatsu());
        entity.setChoshuHoho1gatsu(徴収方法の情報.toEntity().getChoshuHoho1gatsu());
        entity.setChoshuHoho2gatsu(徴収方法の情報.toEntity().getChoshuHoho2gatsu());
        entity.setChoshuHoho3gatsu(徴収方法の情報.toEntity().getChoshuHoho3gatsu());
        entity.setChoshuHohoYoku4gatsu(徴収方法の情報.toEntity().getChoshuHohoYoku4gatsu());
        entity.setChoshuHohoYoku5gatsu(徴収方法の情報.toEntity().getChoshuHohoYoku5gatsu());
        entity.setChoshuHohoYoku6gatsu(徴収方法の情報.toEntity().getChoshuHohoYoku6gatsu());
        entity.setChoshuHohoYoku7gatsu(徴収方法の情報.toEntity().getChoshuHohoYoku7gatsu());
        entity.setChoshuHohoYoku8gatsu(徴収方法の情報.toEntity().getChoshuHohoYoku8gatsu());
        entity.setChoshuHohoYoku9gatsu(徴収方法の情報.toEntity().getChoshuHohoYoku9gatsu());
        entity.setKariNenkinNo(徴収方法の情報.toEntity().getKariNenkinNo());
        entity.setKariNenkinCode(徴収方法の情報.toEntity().getKariNenkinCode());
        entity.setKariHosokuM(徴収方法の情報.toEntity().getKariHosokuM());
        entity.setHonNenkinNo(徴収方法の情報.toEntity().getHonNenkinNo());
        entity.setHonNenkinCode(徴収方法の情報.toEntity().getHonNenkinCode());
        entity.setHonHosokuM(徴収方法の情報.toEntity().getHonHosokuM());
        entity.setYokunendoKariNenkinNo(徴収方法の情報.toEntity().getYokunendoKariNenkinNo());
        entity.setYokunendoKariNenkinCode(徴収方法の情報.toEntity().getYokunendoKariNenkinCode());
        entity.setYokunendoKariHosokuM(徴収方法の情報.toEntity().getYokunendoKariHosokuM());
        entity.setIraiSohuzumiFlag(徴収方法の情報.toEntity().getIraiSohuzumiFlag());
        entity.setTsuikaIraiSohuzumiFlag(徴収方法の情報.toEntity().getTsuikaIraiSohuzumiFlag());
        entity.setTokuchoTeishiNichiji(徴収方法の情報.toEntity().getTokuchoTeishiNichiji());
        entity.setTokuchoTeishiJiyuCode(徴収方法の情報.toEntity().getTokuchoTeishiJiyuCode());
        entity.setState(EntityDataState.Added);
        徴収方法Dac.save(entity);
    }

    /**
     * 徴収方法更新
     *
     * @param entity DbV2001ChoshuHohoEntity
     * @param daichoEntity DbT1001HihokenshaDaichoEntity
     * @return ChoshuHoho
     */
    @Transaction
    public ChoshuHoho upd徴収方法更新(DbV2001ChoshuHohoEntity entity, DbT1001HihokenshaDaichoEntity daichoEntity) {
        DbT2001ChoshuHohoEntity dbTEntity = new DbT2001ChoshuHohoEntity();
        FlexibleYear fukaNendo = entity.getFukaNendo();
        HihokenshaNo hihokenshaNo = entity.getHihokenshaNo();
        if (fukaNendo != null) {
            dbTEntity.setFukaNendo(fukaNendo);
        }
        if (hihokenshaNo != null) {
            dbTEntity.setHihokenshaNo(hihokenshaNo);
        }
        dbTEntity.setRirekiNo(entity.getRirekiNo());
        dbTEntity.setChoshuHoho4gatsu(entity.getChoshuHoho4gatsu());
        dbTEntity.setChoshuHoho5gatsu(entity.getChoshuHoho5gatsu());
        dbTEntity.setChoshuHoho6gatsu(entity.getChoshuHoho6gatsu());
        dbTEntity.setChoshuHoho7gatsu(entity.getChoshuHoho7gatsu());
        dbTEntity.setChoshuHoho8gatsu(entity.getChoshuHoho8gatsu());
        dbTEntity.setChoshuHoho9gatsu(entity.getChoshuHoho9gatsu());
        dbTEntity.setChoshuHoho10gatsu(entity.getChoshuHoho10gatsu());
        dbTEntity.setChoshuHoho11gatsu(entity.getChoshuHoho11gatsu());
        dbTEntity.setChoshuHoho12gatsu(entity.getChoshuHoho12gatsu());
        dbTEntity.setChoshuHoho1gatsu(entity.getChoshuHoho1gatsu());
        dbTEntity.setChoshuHoho2gatsu(entity.getChoshuHoho2gatsu());
        dbTEntity.setChoshuHoho3gatsu(entity.getChoshuHoho3gatsu());
        dbTEntity.setChoshuHohoYoku4gatsu(entity.getChoshuHohoYoku4gatsu());
        dbTEntity.setChoshuHohoYoku5gatsu(entity.getChoshuHohoYoku5gatsu());
        dbTEntity.setChoshuHohoYoku6gatsu(entity.getChoshuHohoYoku6gatsu());
        dbTEntity.setChoshuHohoYoku7gatsu(entity.getChoshuHohoYoku7gatsu());
        dbTEntity.setChoshuHohoYoku8gatsu(entity.getChoshuHohoYoku8gatsu());
        dbTEntity.setChoshuHohoYoku9gatsu(entity.getChoshuHohoYoku9gatsu());
        dbTEntity.setKariNenkinNo(entity.getKariNenkinNo());
        dbTEntity.setKariNenkinCode(entity.getKariNenkinCode());
        dbTEntity.setKariHosokuM(entity.getKariHosokuM());
        dbTEntity.setHonNenkinNo(entity.getHonNenkinNo());
        dbTEntity.setHonNenkinCode(entity.getHonNenkinCode());
        dbTEntity.setHonHosokuM(entity.getHonHosokuM());
        dbTEntity.setYokunendoKariNenkinNo(entity.getYokunendoKariNenkinNo());
        dbTEntity.setYokunendoKariNenkinCode(entity.getYokunendoKariNenkinCode());
        dbTEntity.setYokunendoKariHosokuM(entity.getYokunendoKariHosokuM());
        dbTEntity.setIraiSohuzumiFlag(entity.getIraiSohuzumiFlag());
        dbTEntity.setTsuikaIraiSohuzumiFlag(entity.getTsuikaIraiSohuzumiFlag());
        dbTEntity.setTokuchoTeishiNichiji(entity.getTokuchoTeishiNichiji());
        dbTEntity.setTokuchoTeishiJiyuCode(entity.getTokuchoTeishiJiyuCode());

        ChoshuHoho 徴収方法の情報 = new ChoshuHoho(dbTEntity);
        FlexibleDate 資格取得日 = daichoEntity.getIchigoShikakuShutokuYMD();
        YMDHMS 特別徴収停止日時 = new YMDHMS("");
        FlexibleDate 資格喪失日 = FlexibleDate.EMPTY;
        ChoshuHoho choshuHoho = choshuHohoKoshin.getChoshuHohoKoshinData(徴収方法の情報, 特別徴収停止日時, 資格取得日, 資格喪失日);

        return choshuHoho;
    }

    /**
     * 被保険者徴収方法情報の取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @return DbV2001ChoshuHohoEntity
     */
    @Transaction
    public DbV2001ChoshuHohoEntity select被保険者徴収方法情報の取得(HihokenshaNo 被保険者番号) {
        RString nendo = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        FlexibleYear 賦課年度 = new FlexibleYear(nendo.toString());
        DbV2001ChoshuHohoEntity entity = choshuHohoAliveDac.selectChoshuhohonojohoAll(賦課年度, 被保険者番号);

        return entity;
    }

    /**
     * 被保険者番号の取得
     *
     * @param entity DbT7022ShoriDateKanriEntity
     * @return DbT1001HihokenshaDaichoEntity
     */
    @Transaction
    public List<DbT1001HihokenshaDaichoEntity> select被保険者番号(DbT7022ShoriDateKanriEntity entity) {
        RString 被保険者区分コード = ShikakuKubun._１号.getコード();
        FlexibleDate 対象開始年月日 = entity.getTaishoKaishiYMD();
        FlexibleDate 対象終了年月日 = entity.getTaishoShuryoYMD();
        RString 異動事由コード = CODE;
        INenreitotatsuShikakuIdoChoshuhohoKoshinMapper mapper = mapperProvider.create(INenreitotatsuShikakuIdoChoshuhohoKoshinMapper.class);
        NenreitotatsuShikakuIdoChoshuhohoKoshinMybatisParam param = new NenreitotatsuShikakuIdoChoshuhohoKoshinMybatisParam();
        param.set被保険者区分コード(被保険者区分コード);
        param.set対象開始年月日(対象開始年月日);
        param.set対象終了年月日(対象終了年月日);
        param.set異動事由コード(異動事由コード);

        return mapper.selectHihokenjabango(param);
    }

    /**
     * 年齢到達の異動被保険者取得
     *
     * @return DbT7022ShoriDateKanriEntity shoriDateKanriEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select年齢到達の異動被保険者取得() {
        DbT7022ShoriDateKanriEntity shoriDateKanriEntity = shoriDateKanriDac.selectByKey(サブ業務コード,
                市町村コード, 処理名, 処理枝番, 年度, 年度内連番);
        return shoriDateKanriEntity;
    }
}
