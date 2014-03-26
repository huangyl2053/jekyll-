/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.JuryoininJigyosha;
import jp.co.ndensan.reams.db.dbc.business.JuryoininJigyoshaList;
import jp.co.ndensan.reams.db.dbc.business.KeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.Todokedesha;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.EigyoKeitai;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.JutakuKaishuKeiyakuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KogakuKyufuKeiyakuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShokanbaraiKyufuKeiyakuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.TokuteiFukushiYoguHanbaiKeiyakuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ToriatsukaiKakuyakushoKubun;
import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.business.IKoza;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IHojin;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 受領委任事業者のbusinessクラスとentityクラスのマッピングを行うクラスです。
 *
 * @author N3317 塚田 萌
 */
public final class JuryoininJigyoshaMapper {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private JuryoininJigyoshaMapper() {
    }

    /**
     * 受領委任事業者Entityをbusinessの受領委任事業者クラスにマッピングします。<br/>
     * 引数にnullが渡されたときは、nullを返します。
     *
     * @param entity 受領委任事業者Entity
     * @param 法人 businessの法人クラス
     * @param 口座 businessの口座クラス
     * @return businessの受領委任事業者クラス
     */
    public static JuryoininJigyosha to受領委任事業者(DbT3077JuryoininKeiyakuJigyoshaEntity entity,
            IHojin 法人, IKoza 口座) {

        if (entity == null) {
            return null;
        }
        JuryoininJigyosha 受領委任事業者 = new JuryoininJigyosha(
                create契約番号(entity.getJigyoshaKeiyakuNo()),
                create契約期間(entity),
                entity.getShoriTimestamp(),
                entity.getTodokedeYMD(),
                create届出者(entity),
                entity.getKeiyakuTorokuYMD(),
                create契約事業者(entity, 法人, 口座),
                JutakuKaishuKeiyakuKubun.toValue(entity.getJutakuKaishuKeiyakuUmu()),
                TokuteiFukushiYoguHanbaiKeiyakuKubun.toValue(entity.getTokuteiFukushiYoguHanbaiKeiyakuUmu()),
                ShokanbaraiKyufuKeiyakuKubun.toValue(entity.getShokanbaraiKyufuKeiyakuUmu()),
                KogakuKyufuKeiyakuKubun.toValue(entity.getKogakuKyufuKeiyakuUmu()),
                ToriatsukaiKakuyakushoKubun.toValue(entity.getToriatsukaiKakuyakushoUmu())
        );
        return 受領委任事業者;
    }

    /**
     * 受領委任事業者EntityListをbusinessの受領委任事業者クラスリストにマッピングします。<br/>
     * 引数にnullや空のリストが渡された場合は、空のコレクションを返します。<br/>
     *
     * @param entities 受領委任事業者EntityList
     * @param 法人List businessの法人クラスリスト
     * @param 口座List businessの口座クラスリスト
     * @return businessの受領委任事業者リストクラス
     */
    public static JuryoininJigyoshaList to受領委任事業者List(List<DbT3077JuryoininKeiyakuJigyoshaEntity> entities,
            List<IHojin> 法人List, List<IKoza> 口座List) {

        if (entities == null || entities.isEmpty()) {
            return new JuryoininJigyoshaList(Collections.EMPTY_LIST);
        }

        List<JuryoininJigyosha> 受領委任事業者List = new ArrayList<>();

        for (int i = 0; i < entities.size(); i++) {
            受領委任事業者List.add(to受領委任事業者(entities.get(i), 法人List.get(i), 口座List.get(i)));
        }
        return new JuryoininJigyoshaList(受領委任事業者List);
    }

    /**
     * businessの受領委任事業者クラスを受領委任事業者Entityにマッピングします。<br/>
     * 引数にnullが渡されたときは、nullを返します。
     *
     * @param 受領委任事業者 受領委任事業者
     * @return 受領委任事業者Entity
     */
    public static DbT3077JuryoininKeiyakuJigyoshaEntity to受領委任事業者Entity(JuryoininJigyosha 受領委任事業者) {

        if (受領委任事業者 == null) {
            return null;
        }
        DbT3077JuryoininKeiyakuJigyoshaEntity entity = new DbT3077JuryoininKeiyakuJigyoshaEntity();
        entity.setJigyoshaKeiyakuNo(受領委任事業者.get契約番号().value());
        entity.setKaishiYMD(受領委任事業者.get契約期間().getFrom());
        entity.setShoriTimestamp(受領委任事業者.get処理日時());
        entity.setShuryoYMD(受領委任事業者.get契約期間().getTo());
        entity.setTodokedeYMD(受領委任事業者.get届出年月日());
        entity.setTodokedeAddress(受領委任事業者.get届出者().get住所());
        entity.setTodokedeJigyoshaName(受領委任事業者.get届出者().get事業者名称());
        entity.setTodokedeDaihyoshaName(受領委任事業者.get届出者().get代表者氏名());
        entity.setShikibetsuCode(受領委任事業者.get識別コード());
        entity.setJigyoshaFaxNo(受領委任事業者.get契約事業者().get事業者FAX番号());
        entity.setKeiyakuTorokuYMD(受領委任事業者.get契約登録年月日());
        entity.setSofusakiBusho(受領委任事業者.get契約事業者().get送付先部署());
        entity.setEigyoKeitai(受領委任事業者.get契約事業者().get営業形態().getCode());
        entity.setJutakuKaishuKeiyakuUmu(受領委任事業者.has住宅改修契約());
        entity.setTokuteiFukushiYoguHanbaiKeiyakuUmu(受領委任事業者.has特定福祉用具販売契約());
        entity.setShokanbaraiKyufuKeiyakuUmu(受領委任事業者.has償還払給付契約());
        entity.setKogakuKyufuKeiyakuUmu(受領委任事業者.has高額給付契約());
        entity.setKeiyakuJigyoshaNo(受領委任事業者.get契約事業者().get事業者番号());
        entity.setToriatsukaiKakuyakushoUmu(受領委任事業者.has取扱確約書());

        return entity;
    }

    private static KeiyakuNo create契約番号(RString 契約番号) {
        return new KeiyakuNo(契約番号);
    }

    private static Range<FlexibleDate> create契約期間(DbT3077JuryoininKeiyakuJigyoshaEntity entity) {
        FlexibleDate start = entity.getKaishiYMD();
        FlexibleDate end = entity.getShuryoYMD();
        Range 契約期間 = new Range(start, end);

        return 契約期間;
    }

    private static Todokedesha create届出者(DbT3077JuryoininKeiyakuJigyoshaEntity entity) {
        RString address = entity.getTodokedeAddress();
        RString jigyoshaName = entity.getTodokedeJigyoshaName();
        RString daihyoshaName = entity.getTodokedeDaihyoshaName();

        return new Todokedesha(address, jigyoshaName, daihyoshaName);
    }

    private static KeiyakuJigyosha create契約事業者(
            DbT3077JuryoininKeiyakuJigyoshaEntity entity, IHojin 法人, IKoza 口座) {

        JigyoshaNo jigyoshaNo = entity.getKeiyakuJigyoshaNo();
        IHojin hojin = 法人;
        TelNo jigyoshaFaxNo = entity.getJigyoshaFaxNo();
        EigyoKeitai eigyoKeitai = EigyoKeitai.toValue(entity.getEigyoKeitai());
        RString sofusakiBusho = entity.getSofusakiBusho();
        IKoza koza = 口座;
        //TODO n3317塚田萌　ISofusakiは本実装の時に対応する。期限　本実装完了まで
//        ISofusaki sofusaki = 送付先;

        return new KeiyakuJigyosha(jigyoshaNo, hojin, jigyoshaFaxNo, eigyoKeitai, sofusakiBusho, koza);
    }
}
