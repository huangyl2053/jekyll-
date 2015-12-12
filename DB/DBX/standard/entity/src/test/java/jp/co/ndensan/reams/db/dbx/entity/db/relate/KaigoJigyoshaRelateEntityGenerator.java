/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.relate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7060KaigoJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7062KaigoJigyoshaDaihyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 介護事業者関連エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author N3317 塚田 萌
 */
public final class KaigoJigyoshaRelateEntityGenerator {

    private KaigoJigyoshaRelateEntityGenerator() {

    }

    public static KaigoJigyoshaRelateEntity createKaigoJigyoshaRelateEntity() {
        List<DbT7063KaigoJigyoshaShiteiServiceEntity> list = new ArrayList<>();
        list.add(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity());
        return new KaigoJigyoshaRelateEntity(
                DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity(),
                DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity(),
                list
        );
    }

    public static KaigoJigyoshaRelateEntity createKaigoJigyoshaRelateEntity(FlexibleDate 有効開始日) {
        DbT7060KaigoJigyoshaEntity jigyoshaEntity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
        jigyoshaEntity.setYukoKaishiYMD(有効開始日);
        DbT7062KaigoJigyoshaDaihyoshaEntity daihyoshaEntity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
        daihyoshaEntity.setYukoKaishiYMD(有効開始日);
        List<DbT7063KaigoJigyoshaShiteiServiceEntity> list = new ArrayList<>();
        list.add(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity());

        return new KaigoJigyoshaRelateEntity(jigyoshaEntity, daihyoshaEntity, list);
    }
}
