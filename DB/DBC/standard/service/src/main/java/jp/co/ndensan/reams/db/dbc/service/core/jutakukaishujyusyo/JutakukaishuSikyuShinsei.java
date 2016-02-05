/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jutakukaishujyusyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujyusyo.FukushiyouguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * @author ycb
 */
public class JutakukaishuSikyuShinsei {

    private final MapperProvider mapperProvider;

    public JutakukaishuSikyuShinsei() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    public static JutakukaishuSikyuShinsei createInstance() {
        return InstanceProvider.create(JutakukaishuSikyuShinsei.class);
    }

    public List<FukushiyouguKonyuhiShikyuShinsei> getShokanShikyuShinseiList(HihokenshaNo 被保険者番号) {
        List<FukushiyouguKonyuhiShikyuShinsei> list = new ArrayList<FukushiyouguKonyuhiShikyuShinsei>();
        FukushiyouguKonyuhiShikyuShinsei s = new FukushiyouguKonyuhiShikyuShinsei();
        s.set明細番号(new RString("0213"));
        s.setサービス提供年月(new FlexibleYearMonth("199003"));
        s.set事業者番号(new RString("0213"));
        s.set商品名(new RString("0213"));
        s.set支払区分(new RString("1"));
        s.set整理番号(new RString("0213"));
        s.set様式番号(new RString("0213"));
        s.set決定日(new FlexibleDate("20140501"));
        s.set申請年月日(new FlexibleDate("20140501"));
        s.set被保険者番号(new RString("0213"));
        s.set購入金額合計(new RString("0213"));

        list.add(s);
        list.add(s);
        return list;
    }

    public List<DbT3118ShikibetsuNoKanriEntity> getYoshikiName(RDate サービス年月) {//DbT3118ShikibetsuNoKanriEntity
        List<DbT3118ShikibetsuNoKanriEntity> list = new ArrayList<DbT3118ShikibetsuNoKanriEntity>();
        DbT3118ShikibetsuNoKanriEntity db = new DbT3118ShikibetsuNoKanriEntity();
        db.setShikibetsuNo(new RString("1"));
        db.setRyakusho(new RString("djf"));
        DbT3118ShikibetsuNoKanriEntity dbs = new DbT3118ShikibetsuNoKanriEntity();
        dbs.setShikibetsuNo(new RString("2"));
        dbs.setRyakusho(new RString("sds"));
        list.add(db);
        list.add(dbs);
        return list;
    }
}
