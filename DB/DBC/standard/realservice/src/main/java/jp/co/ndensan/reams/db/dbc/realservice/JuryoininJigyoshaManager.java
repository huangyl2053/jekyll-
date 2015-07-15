/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.realservice;

import jp.co.ndensan.reams.db.dbc.business.JuryoininJigyosha;
import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.business.mapper.JuryoininJigyoshaMapper;
import jp.co.ndensan.reams.db.dbc.persistence.basic.JuryoininJigyoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.business.IKaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.realservice.IKaigoJigyoshaFinder;
import jp.co.ndensan.reams.ur.urc.business.IKoza;
//TODO n8233 朴　jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.hojin.IHojinに変更
//import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IHojin;
import jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.hojin.IHojin;
//TODO n8233 朴　jp.co.ndensan.reams.ua.uax.realservice.HojinServiceに変更
//import jp.co.ndensan.reams.ur.urz.realservice.HojinService;
import jp.co.ndensan.reams.ua.uax.realservice.shikibetsutaisho.ShikibetsuTaishoService;
//TODO n8233 朴　jp.co.ndensan.reams.ua.uax.realservice.shikibetsutaisho.IHojinFinderに変更
//import jp.co.ndensan.reams.ur.urz.realservice.IHojinFinder;
import jp.co.ndensan.reams.ua.uax.realservice.shikibetsutaisho.IHojinFinder;
import jp.co.ndensan.reams.ur.urc.realservice.IKozaManager;
import jp.co.ndensan.reams.ur.urc.realservice.KozaService;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 受領委任事業者を管理するクラスです。
 *
 * @author N3317 塚田 萌
 */
public class JuryoininJigyoshaManager {

    private final JuryoininJigyoshaDac dac;
    private IKaigoJigyoshaFinder jigyoshaFinder;
    private final IHojinFinder hojinFinder;
    private final IKozaManager kozaFinder;

    /**
     * デフォルトコンストラクタです。
     */
    public JuryoininJigyoshaManager() {
        dac = InstanceProvider.create(JuryoininJigyoshaDac.class);

        //TODO n3317塚田萌 _KaigoJigyoshaFinder() の実装が完了したらgetInstance()を行う。
//        jigyoshaFinder = KaigoJigyoshaFinderFactory.getInstance();
        hojinFinder = ShikibetsuTaishoService.getHojinFinder();
        kozaFinder = KozaService.createKozaManager();
    }

    /**
     * 外部からDacを取得する、テスト用パッケージプライベートコンストラクタです。
     *
     * @param dac テスト用Dac
     */
    JuryoininJigyoshaManager(JuryoininJigyoshaDac dac, IKaigoJigyoshaFinder jigyoshaFinder, IHojinFinder hojinFinder, IKozaManager kozaFinder) {
        this.dac = dac;
        this.jigyoshaFinder = jigyoshaFinder;
        this.hojinFinder = hojinFinder;
        this.kozaFinder = kozaFinder;
    }

    /**
     * 契約番号に該当する受領委任事業者の情報を取得します。<br/>
     * 契約事業者番号がある時は、識別コードがないので契約事業者番号を使って識別コードを取得します。
     *
     * @param 契約番号 契約番号
     * @return 契約番号に該当する受領委任事業者情報
     */
    public JuryoininJigyosha get受領委任事業者(KeiyakuNo 契約番号) {
        DbT3077JuryoininKeiyakuJigyoshaEntity entity = dac.select(契約番号);

        if (entity == null) {
            return null;
        }
        if (entity.getKeiyakuJigyoshaNo() != null) {
            set識別コードAs(entity);
        }
        IHojin 法人 = find法人(entity.getShikibetsuCode(), entity.getKaishiYMD());
        IKoza 口座 = find口座(entity.getShikibetsuCode(), entity.getKaishiYMD());

        return JuryoininJigyoshaMapper.to受領委任事業者(entity, 法人, 口座);
    }

    //TODO n3317塚田萌　get受領委任事業者(検索条件)は本実装の時に対応する。期限　本実装完了まで
//    public List<JuryoininJigyosha> get受領委任事業者(検索条件) {}
    /**
     * 引数の受領委任事業者情報を追加します。
     *
     * @param 受領委任事業者 追加する受領委任事業者
     * @return 更新に成功した場合はtrue、失敗した場合はfalseを返します。
     */
    public boolean save(JuryoininJigyosha 受領委任事業者) {
        DbT3077JuryoininKeiyakuJigyoshaEntity entity
                = JuryoininJigyoshaMapper.to受領委任事業者Entity(受領委任事業者);
        return is更新成功(dac.insert(entity));
    }

    /**
     * 引数の受領委任事業者情報を論理削除します。
     *
     * @param 受領委任事業者 論理削除する受領委任事業者
     * @return 更新に成功した場合はtrue、失敗した場合はfalseを返します。
     */
    public boolean remove(JuryoininJigyosha 受領委任事業者) {
        DbT3077JuryoininKeiyakuJigyoshaEntity entity
                = JuryoininJigyoshaMapper.to受領委任事業者Entity(受領委任事業者);
        return is更新成功(dac.delete(entity));
    }

    private void set識別コードAs(DbT3077JuryoininKeiyakuJigyoshaEntity entity) {
        IKaigoJigyosha 介護事業者;
        介護事業者 = find介護事業者(entity.getKeiyakuJigyoshaNo());
        //TODO n8223 IKaigoJigyoshaのクラスなくなることで、代わりするクラスが必要がある。
        //entity.setShikibetsuCode(介護事業者.get識別コード());
    }

    private IKaigoJigyosha find介護事業者(JigyoshaNo 事業者番号) {
        return jigyoshaFinder.get特定の事業者番号の介護事業者(事業者番号.value());
    }

    private IHojin find法人(ShikibetsuCode 識別コード, FlexibleDate 契約開始日) {
        //TODO n3317塚田萌　RDateからFlexibleDateに変更されたら.toRDate()を外す。
        //TODO n8233 朴　get法人(識別コード, 契約開始日.toRDate()　→　get法人(GyomuCode.DB介護保険, 識別コード)に変更する。
        //TOD  n8233 朴  契約開始日.toRDate()に関しては、必要があるので、対応必要がある。
        return hojinFinder.get法人(GyomuCode.DB介護保険, 識別コード);//.get法人(識別コード, 契約開始日.toRDate());

    }

    private IKoza find口座(ShikibetsuCode 識別コード, FlexibleDate 契約開始日) {
        //TODO n3317塚田萌　RDateからFlexibleDateに変更されたら.toRDate()を外す。
        //TODO n3317塚田萌　kozaFinderの修正が完了した時に対応する。
        RString 業務コード = new RString("業務コード");
        KamokuCode 科目コード = new KamokuCode(new RString("AAA"));
        return kozaFinder.get口座(契約開始日.toRDate(), 識別コード, GyomuCode.DB介護保険, 科目コード).get(0);
    }

    private boolean is更新成功(int 更新件数) {
        return 更新件数 != 0;
    }
}
