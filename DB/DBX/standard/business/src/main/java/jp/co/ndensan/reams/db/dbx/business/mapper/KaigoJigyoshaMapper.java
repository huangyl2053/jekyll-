/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.IKaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;

/**
 * 介護事業者エンティティを変換するクラスです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護事業者マッパー
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass
 * @reference
 * @deprecated 新ビジネス対応により削除されます。
 */
public final class KaigoJigyoshaMapper {
    //TODO n3423 樋木隆真 KaigoJigyoshaEntityをUrT0518KaigoJigyoshaEntityに変更するべきだが項目数が多く、
    //                   またこのクラス自体削除する可能性があるため新ビジネス対応時に対応する。

    private KaigoJigyoshaMapper() {
        //インスタンス生成禁止のため
        throw new AssertionError();
    }

    /**
     * 介護事業者Entityのリストより事業者の操作クラスをリストとして作成します。
     *
     * @param jigyoshas 介護事業者Entityのリスト
     * @return 介護事業者の操作クラスのリスト
     */
    public static List<IKaigoJigyosha> toKaigoJigyoshas(List<DbT7060KaigoJigyoshaEntity> jigyoshas) {
        List<IKaigoJigyosha> 事業者s = new ArrayList<>();
//        for (DbT7060KaigoJigyoshaEntity 事業者 : jigyoshas) {
////            事業者s.add(toKaigoJigyosha(事業者));
//        }
        return 事業者s;
    }

    /**
     * 介護事業者Entityより事業者の操作クラスを作成します。
     *
     * @param jigyosha 介護事業者Entity
     * @return 介護事業者の操作クラス
     */
    public static IKaigoJigyosha toKaigoJigyosha(DbT7060KaigoJigyoshaEntity jigyosha) {

        return null;
    }
}
