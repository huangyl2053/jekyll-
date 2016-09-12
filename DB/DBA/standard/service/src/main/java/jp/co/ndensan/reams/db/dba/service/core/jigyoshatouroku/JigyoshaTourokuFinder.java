/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.jigyoshatouroku;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiBusiness;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.kaigojigyoshashiteiservice.IKaigoJigyoshaShiteiServiceMapper;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigojigyosha.kaigojigyosha.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7062KaigoJigyoshaDaihyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者登録です。
 *
 * @reamsid_L DBA-0340-050 lijia
 *
 */
public class JigyoshaTourokuFinder {

    private final MapperProvider mapperProvider;
    private final DbT7060KaigoJigyoshaDac dbT7060Dac;
    private final DbT7062KaigoJigyoshaDaihyoshaDac dbT7062Dac;
    private final DbT7063KaigoJigyoshaShiteiServiceDac dbT7063Dac;
    private static final RString 状態_更新 = new RString("更新");

    /**
     * コンストラクタです。
     */
    JigyoshaTourokuFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT7060Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        this.dbT7062Dac = InstanceProvider.create(DbT7062KaigoJigyoshaDaihyoshaDac.class);
        this.dbT7063Dac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dbT7060Dac 介護事業者Dac
     * @param dbT7062Dac 介護事業者代表者Dac
     * @param dbT7063Dac 介護事業者指定サービスDac
     */
    JigyoshaTourokuFinder(
            MapperProvider mapperProvider,
            DbT7060KaigoJigyoshaDac dbT7060Dac,
            DbT7062KaigoJigyoshaDaihyoshaDac dbT7062Dac,
            DbT7063KaigoJigyoshaShiteiServiceDac dbT7063Dac
    ) {
        this.mapperProvider = mapperProvider;
        this.dbT7060Dac = dbT7060Dac;
        this.dbT7062Dac = dbT7062Dac;
        this.dbT7063Dac = dbT7063Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaDaichoSakuseiManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaDaichoSakuseiManager}のインスタンス
     */
    public static JigyoshaTourokuFinder createInstance() {
        return InstanceProvider.create(JigyoshaTourokuFinder.class);
    }

    /**
     * 介護事業者{@link KaigoJigyosha}を削除します。
     *
     * @param 介護事業者 介護事業者
     * @return 削除あり:true、削除なし:false <br>
     * いずれかのテーブルに削除があればtrueを返す、いずれのテーブルもunchangedで削除無しの場合falseを返す
     */
    @Transaction
    public boolean saveOrDelete(KaigoJigyosha 介護事業者) {
        requireNonNull(介護事業者, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者"));
        if (!介護事業者.hasChanged()) {
            return false;
        }
        介護事業者 = 介護事業者.deleted();
        save介護事業者代表者リスト(介護事業者.getKaigoJigyoshaDaihyoshaList());
        return 1 == dbT7060Dac.saveOrDeletePhysicalBy(介護事業者.toEntity());
    }

    /**
     * サービス一覧情報{@link KaigoJigyosha}を削除します。
     *
     * @param サービス一覧情報 サービス一覧情報
     * @return 削除あり:true、削除なし:false <br>
     * いずれかのテーブルに削除があればtrueを返す、いずれのテーブルもunchangedで削除無しの場合falseを返す
     */
    @Transaction
    public boolean isShiteiServiceDelete(KaigoJigyoshaShiteiService サービス一覧情報) {
        requireNonNull(サービス一覧情報, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス一覧情報"));
        if (!サービス一覧情報.hasChanged()) {
            return false;
        }
        DbT7063KaigoJigyoshaShiteiServiceEntity サービス一覧情報Entity = サービス一覧情報.toEntity();
        サービス一覧情報Entity.setState(EntityDataState.Deleted);
        return 1 == dbT7063Dac.delete(サービス一覧情報Entity);
    }

    private boolean save介護事業者代表者リスト(List<KaigoJigyoshaDaihyosha> 介護事業者代表者List) {
        return 1 == dbT7062Dac.saveOrDeletePhysicalBy(介護事業者代表者List.get(0).toEntity());
    }

    /**
     * 介護事業者情報の編集します。
     *
     * @param entity 介護事業者
     * @param 状態 処理状態
     * @return KaigoJigyoshaEntity 介護事業者RelateEntity *
     */
    public KaigoJigyoshaEntity 介護事業者情報の編集(DbT7060KaigoJigyoshaEntity entity, RString 状態) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者"));
        KaigoJigyoshaEntity kaigoJigyoshaEntity = new KaigoJigyoshaEntity();
        if (状態_更新.equals(状態)) {
            entity.setState(EntityDataState.Modified);
        } else {
            entity.setState(EntityDataState.Deleted);
        }
        kaigoJigyoshaEntity.set介護事業者Entity(entity);
        return kaigoJigyoshaEntity;
    }

    /**
     * 介護事業者情報の編集します。
     *
     * @param jigyoshaNo 事業者番号
     * @param yukoKaishiYMD 有効開始日
     * @return boolean boolean
     */
    public boolean 事業者番号重複チェック(JigyoshaNo jigyoshaNo, FlexibleDate yukoKaishiYMD) {
        requireNonNull(jigyoshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者"));
        requireNonNull(yukoKaishiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始日"));
        DbT7060KaigoJigyoshaEntity dbt7060Entity = dbT7060Dac.selectByKey(jigyoshaNo, yukoKaishiYMD);
        return dbt7060Entity != null;
    }

    /**
     * サービス一覧情報取得。
     *
     * @param chkFlag 「過去の履歴も含めて表示」にチェックオン・オフ
     * @return サービス一覧情報取得
     */
    @Transaction
    public SearchResult<KaigoJogaiTokureiBusiness> getServiceItiranJoho(boolean chkFlag) {

        List<KaigoJogaiTokureiBusiness> serviceShuruiList = new ArrayList();
        List<KaigoJogaiTokureiRelateEntity> サービス一覧情報;
        IKaigoJigyoshaShiteiServiceMapper iKaigoJigyoshaShisetsuKanri = mapperProvider.create(IKaigoJigyoshaShiteiServiceMapper.class);
        if (chkFlag) {
            サービス一覧情報 = iKaigoJigyoshaShisetsuKanri.getKaigoJigyoshaShiteiServiceRireki(new FlexibleDate(RDate.getNowDate().toDateString()));
        } else {
            サービス一覧情報 = iKaigoJigyoshaShisetsuKanri.getKaigoJigyoshaShiteiService(new FlexibleDate(RDate.getNowDate().toDateString()));
        }

        for (KaigoJogaiTokureiRelateEntity entity : サービス一覧情報) {
            KaigoJogaiTokureiRelateEntity relateEntity = new KaigoJogaiTokureiRelateEntity();
            KaigoJogaiTokureiBusiness business;
            if (entity == null) {
                relateEntity.setJigyoshaName(RString.EMPTY);
                relateEntity.setKanrishaName(RString.EMPTY);
                relateEntity.setServiceShuruiCode(RString.EMPTY);
                relateEntity.setYukoKaishiYMD(RString.EMPTY);
                relateEntity.setYukoShuryoYMD(RString.EMPTY);
                business = new KaigoJogaiTokureiBusiness(relateEntity);
            } else {
                business = new KaigoJogaiTokureiBusiness(entity);
            }
            serviceShuruiList.add(business);
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }
}
