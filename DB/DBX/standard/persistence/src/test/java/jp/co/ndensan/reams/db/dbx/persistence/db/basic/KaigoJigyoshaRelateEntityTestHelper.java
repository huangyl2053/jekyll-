/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7060KaigoJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7062KaigoJigyoshaDaihyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.KaigoJigyoshaRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * KaigoJigyoshaRelateEntityのテストデータ作成クラスです。
 *
 * @author N8187 久保田 英男
 */
public final class KaigoJigyoshaRelateEntityTestHelper {

    private static final KaigoJigyoshaNo 事業者番号 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
    private static final FlexibleDate 有効開始日1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
    private static final FlexibleDate 有効開始日2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日.minusDay(10);

    private KaigoJigyoshaRelateEntityTestHelper() {
    }

    /**
     * {@link KaigoJigyoshaRelateEntity}を生成して返します。
     *
     * @return {@link KaigoJigyoshaRelateEntity}
     */
    public static KaigoJigyoshaRelateEntity createModel1() {

        List<DbT7063KaigoJigyoshaShiteiServiceEntity> list = new ArrayList<>();
        DbT7060KaigoJigyoshaEntity urt0518Entity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
        DbT7062KaigoJigyoshaDaihyoshaEntity urt0520Entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
        DbT7063KaigoJigyoshaShiteiServiceEntity urt0521Entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
        urt0518Entity.setJigyoshaNo(事業者番号);
        urt0518Entity.setYukoKaishiYMD(有効開始日1);
        urt0520Entity.setJigyoshaNo(事業者番号);
        urt0520Entity.setYukoKaishiYMD(有効開始日1);
        urt0521Entity.setJigyoshaNo(事業者番号);
        list.add(urt0521Entity);

        return new KaigoJigyoshaRelateEntity(
                urt0518Entity,
                urt0520Entity,
                list);
    }

    /**
     * {@link KaigoJigyoshaRelateEntity}を生成して返します。
     *
     * @return {@link KaigoJigyoshaRelateEntity}
     */
    public static KaigoJigyoshaRelateEntity createModel2() {

        List<DbT7063KaigoJigyoshaShiteiServiceEntity> list = new ArrayList<>();
        DbT7060KaigoJigyoshaEntity urt0518Entity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
        DbT7062KaigoJigyoshaDaihyoshaEntity urt0520Entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
        DbT7063KaigoJigyoshaShiteiServiceEntity urt0521Entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
        urt0518Entity.setJigyoshaNo(事業者番号);
        urt0518Entity.setYukoKaishiYMD(有効開始日2);
        urt0520Entity.setJigyoshaNo(事業者番号);
        urt0520Entity.setYukoKaishiYMD(有効開始日2);
        urt0521Entity.setJigyoshaNo(事業者番号);
        list.add(urt0521Entity);

        return new KaigoJigyoshaRelateEntity(
                urt0518Entity,
                urt0520Entity,
                list);
    }
}
