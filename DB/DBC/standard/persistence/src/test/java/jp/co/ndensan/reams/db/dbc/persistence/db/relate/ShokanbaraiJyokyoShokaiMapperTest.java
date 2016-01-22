/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokaiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7120TokuteiShinryoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ServiceTeikyoShomeisho;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanbaraijyokyoshokai.IShokanbaraiJyokyoShokaiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author SE1007
 */
public class ShokanbaraiJyokyoShokaiMapperTest extends DbcTestDacBase {

    private static IShokanbaraiJyokyoShokaiMapper sut;

    @Before
    public void setUp() {
//        sqlSession.getConfiguration().addMapper(IShokanbaraiJyokyoShokaiMapper.class);
        sut = sqlSession.getMapper(IShokanbaraiJyokyoShokaiMapper.class);
    }

    @Test
    public void getサービス提供証明書一覧() {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1234"),
                new RString("1122"),
                null,
                null,
                null,
                null,
                null);
        List<ServiceTeikyoShomeisho> entityList = sut.getサービス提供証明書一覧(parameter);
        System.out.print(entityList.size());
    }

    @Test
    public void get償還払請求明細一覧() {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1111"),
                new RString("2222"),
                new JigyoshaNo(new RString("3333")),
                new RString("4444"),
                null,
                new ServiceShuruiCode(new RString("5555")),
                null);
        List<ShokanMeisaiEntity> entityList = sut.get償還払請求明細一覧(parameter);
        System.out.print(entityList.size());
    }

    @Test
    public void get償還払請求明細住特一覧() {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1111"),
                new RString("2222"),
                new JigyoshaNo(new RString("3333")),
                new RString("4444"),
                new RString("0"),
                new ServiceShuruiCode(new RString("5555")),
                null);
        List<ShokanMeisaiJushochiTokureiEntity> entityList = sut.get償還払請求明細住特一覧(parameter);
        System.out.print(entityList.size());
    }

    @Test
    public void get償還払請求サービス計画200904データ() {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1111"),
                new RString("2222"),
                new JigyoshaNo(new RString("3333")),
                new RString("4444"),
                new RString("0"),
                null,
                null);
        List<ShokanServicePlan200904Entity> entityList = sut.get償還払請求サービス計画200904データ(parameter);

        System.out.print(entityList.size());
    }

    @Test
    public void get償還払請求サービス計画200604データ() {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1111"),
                new RString("2222"),
                new JigyoshaNo(new RString("3333")),
                new RString("4444"),
                new RString("0"),
                null,
                null);
        List<ShokanServicePlan200604Entity> entityList = sut.get償還払請求サービス計画200604データ(parameter);

        System.out.print(entityList.size());
    }

    @Test
    public void get償還払請求サービス計画200004データ() {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1111"),
                new RString("2222"),
                new JigyoshaNo(new RString("3333")),
                new RString("4444"),
                new RString("0"),
                null,
                null);
        List<ShokanServicePlan200004Entity> entityList = sut.get償還払請求サービス計画200004データ(parameter);

        System.out.print(entityList.size());
    }

    @Test
    public void get償還払請求集計データ() {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1111"),
                new RString("2222"),
                new JigyoshaNo(new RString("3333")),
                new RString("4444"),
                new RString("0"),
                null,
                null);
        List<ShokanShukeiEntity> entityList = sut.get償還払請求集計データ(parameter);

        System.out.print(entityList.size());
    }

    @Test
    public void get償還払請求社会福祉法人軽減額データ() {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1111"),
                new RString("2222"),
                new JigyoshaNo(new RString("3333")),
                new RString("4444"),
                new RString("0"),
                null,
                null);
        List<ShokanShakaiFukushiHojinKeigengakuEntity> entityList = sut.get償還払請求社会福祉法人軽減額データ(parameter);

        System.out.print(entityList.size());
    }

    @Test
    public void get識別番号管理データ() {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                null,
                new FlexibleYearMonth(new RString("201406")),
                null,
                new RString("2222"),
                null,
                null,
                null,
                null,
                null);
        List<DbT3118ShikibetsuNoKanriEntity> entityList = sut.get識別番号管理データ(parameter);

        System.out.print(entityList.size());
    }

    @Test
    public void get介護事業者情報() {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                null,
                new FlexibleYearMonth(new RString("201406")),
                null,
                null,
                new JigyoshaNo(new RString("3333")),
                null,
                null,
                null,
                null);
        List<DbT7060KaigoJigyoshaEntity> entityList = sut.get介護事業者情報(parameter);

        System.out.print(entityList.size());
    }

    @Test
    public void get特定診療サービスコード() {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                null,
                new FlexibleYearMonth(new RString("201406")),
                null,
                new RString("2222"),
                null,
                null,
                null,
                null,
                null);
        List<DbT7120TokuteiShinryoServiceCodeEntity> entityList = sut.get特定診療サービスコード(parameter);

        System.out.print(entityList.size());
    }
}
