/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.IKaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.IKaigoServiceTypeCode;
import jp.co.ndensan.reams.db.dbx.business._KaigoServiceTypeCode;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.basic.KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Ignore;
import static org.mockito.Mockito.*;

/**
 * 事業者マネージャクラスのテストクラスです。
 *
 * @author n2818 西澤 貴幸
 */
//TODO n3317 塚田萌　削除対象のクラスでテストエラーするのでスキップする。介護事業者の修正が完了したら削除する。
@Ignore
public class _KaigoJigyoshaFinderTest extends DbxTestBase {

    private final KaigoJigyoshaNo 事業者番号 = new KaigoJigyoshaNo("0123456789");

    @Test
    public void ServiceTypeCodeが01のとき_サービス種類コードが01を含む事業者の事業者番号が取得される() {

        IKaigoServiceTypeCode サービス種類コード = new _KaigoServiceTypeCode(new RString("01"));
        List<RString> 事業者番号s = new ArrayList();
        事業者番号s.add(事業者番号.value());
        事業者番号s.add(事業者番号.value());
        事業者番号s.add(事業者番号.value());

        DbT7060KaigoJigyoshaDac 事業者Dac = mock(DbT7060KaigoJigyoshaDac.class);
        when(事業者Dac.select特定の事業者番号の事業者List(事業者番号s)).thenReturn(create事業者エンティティs());

        DbT7063KaigoJigyoshaShiteiServiceDac 事業指定サービスDac = mock(DbT7063KaigoJigyoshaShiteiServiceDac.class);
        when(事業指定サービスDac.select特定のサービス種類コードのサービス種類一覧(サービス種類コード.getValue())).thenReturn(create事業者指定サービスエンティティs());
        IKaigoJigyoshaFinder 事業者マネージャ = new _KaigoJigyoshaFinder(事業者Dac, 事業指定サービスDac);
        List<IKaigoJigyosha> sut = 事業者マネージャ.get特定の指定サービスを含む事業者一覧(サービス種類コード);
        assertThat(sut.get(0).get事業者番号(), is(事業者番号));
    }

    @Test
    public void ServiceTypeCodeが99のとき_一件も取得されずCollections_EMPTY_LISTが取得される() {
        IKaigoServiceTypeCode サービス種類コード = new _KaigoServiceTypeCode(new RString("99"));

        DbT7060KaigoJigyoshaDac 事業者Dac = mock(DbT7060KaigoJigyoshaDac.class);
        DbT7063KaigoJigyoshaShiteiServiceDac 事業指定サービスDac = mock(DbT7063KaigoJigyoshaShiteiServiceDac.class);
        when(事業指定サービスDac.select特定のサービス種類コードのサービス種類一覧(サービス種類コード.getValue())).thenReturn(null);
        IKaigoJigyoshaFinder 事業者マネージャ = new _KaigoJigyoshaFinder(事業者Dac, 事業指定サービスDac);
        List<IKaigoJigyosha> sut = 事業者マネージャ.get特定の指定サービスを含む事業者一覧(サービス種類コード);
        assertThat(sut, is(Collections.EMPTY_LIST));
    }

    @Test
    public void JigyoshaShubetsu_介護保険施設かつ事業者番号が_0123456789のとき_該当の事業者が取得され_get事業者番号で指定した事業所番号に等しい() {
        DbT7060KaigoJigyoshaDac 事業者Dac = mock(DbT7060KaigoJigyoshaDac.class);
        when(事業者Dac.selectByKey(事業者番号, FlexibleDate.MIN)).thenReturn(create事業者エンティティ());
        DbT7063KaigoJigyoshaShiteiServiceDac 事業者指定サービスDac = mock(DbT7063KaigoJigyoshaShiteiServiceDac.class);
        IKaigoJigyoshaFinder 事業者マネージャ = new _KaigoJigyoshaFinder(事業者Dac, 事業者指定サービスDac);
        IKaigoJigyosha sut = 事業者マネージャ.get特定の事業者番号の介護事業者(事業者番号.value());

        assertThat(sut.get事業者番号(), is(事業者番号));
    }

    @Test
    public void JigyoshaShubetsu_介護適用除外施設かつ事業者番号が_9876543210のとき_該当の事業者がなく_Nullが取得される() {
        DbT7060KaigoJigyoshaDac 事業者Dac = mock(DbT7060KaigoJigyoshaDac.class);
        when(事業者Dac.select特定の事業者番号の事業者List(Arrays.asList(new RString("9876543210")))).thenReturn(null);
        DbT7063KaigoJigyoshaShiteiServiceDac 事業者指定サービスDac = mock(DbT7063KaigoJigyoshaShiteiServiceDac.class);
        IKaigoJigyoshaFinder 事業者マネージャ = new _KaigoJigyoshaFinder(事業者Dac, 事業者指定サービスDac);
        IKaigoJigyosha sut = 事業者マネージャ.get特定の事業者番号の介護事業者(事業者番号.value());

        assertNull(sut);
    }

    private List<KaigoJigyoshaShiteiServiceEntity> create事業者指定サービスエンティティs() {
        List<KaigoJigyoshaShiteiServiceEntity> 指定サービスs = new ArrayList<>();
        指定サービスs.add(create事業者指定サービスエンティティ());
        指定サービスs.add(create事業者指定サービスエンティティ());
        指定サービスs.add(create事業者指定サービスエンティティ());
        return 指定サービスs;
    }

    private KaigoJigyoshaShiteiServiceEntity create事業者指定サービスエンティティ() {
        KaigoJigyoshaShiteiServiceEntity 事業者指定サービスエンティティ;
        事業者指定サービスエンティティ = new KaigoJigyoshaShiteiServiceEntity();
        事業者指定サービスエンティティ.set事業者番号(事業者番号.value());

        return 事業者指定サービスエンティティ;
    }

    private List<DbT7060KaigoJigyoshaEntity> create事業者エンティティs() {
        List<DbT7060KaigoJigyoshaEntity> 事業者s = new ArrayList();
        事業者s.add(create事業者エンティティ());
        事業者s.add(create事業者エンティティ());
        事業者s.add(create事業者エンティティ());
        return 事業者s;
    }

    private DbT7060KaigoJigyoshaEntity create事業者エンティティ() {
        DbT7060KaigoJigyoshaEntity 事業者エンティティ;
        事業者エンティティ = new DbT7060KaigoJigyoshaEntity();
        return 事業者エンティティ;
    }
}
