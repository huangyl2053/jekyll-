/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.gappei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.gappei.GappeiJohoCollection;
import jp.co.ndensan.reams.db.dbz.business.gappei.GappeiShichosonCollection;
import jp.co.ndensan.reams.db.dbz.business.gappei.GappeiShichosonJohoCollection;
import jp.co.ndensan.reams.db.dbz.business.gappei.KoikiGappeiShichosonJohoCollection;
import jp.co.ndensan.reams.db.dbz.business.koiki.KoikiKoseiShichosons;
import jp.co.ndensan.reams.db.dbz.model.gappei.GappeiShichosonJohoModel;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiJoho;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiShichoson;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiShichosonJoho;
import jp.co.ndensan.reams.db.dbz.model.gappei.IKoikiGappeiShichosonJoho;
import jp.co.ndensan.reams.db.dbz.model.gappei.KoikiGappeiShichosonJohoModel;
import jp.co.ndensan.reams.db.dbz.model.koiki.IKoikiKoseiShichoson;
import jp.co.ndensan.reams.db.dbz.persistence.basic.GappeiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.basic.GappeiShichosonDac;
import jp.co.ndensan.reams.db.dbz.persistence.basic.KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.realservice.search.GappeiJohoSearchItem;
import jp.co.ndensan.reams.db.dbz.realservice.search.GappeiShichosonSearchItem;
import jp.co.ndensan.reams.db.dbz.realservice.search.KoseiShichosonMasterSearchItem;
import jp.co.ndensan.reams.ur.urz.realservice.search.INewSearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.SearchConditionFactory;
import jp.co.ndensan.reams.ur.urz.realservice.search.StringOperator;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 合併市町村情報を取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class GappeiShichosonFinder implements IGappeiShichosonFinder {

    private final GappeiJohoDac gappeiJohoDac;
    private final GappeiShichosonDac gappeiShichosonDac;
    private final KoseiShichosonMasterDac koseiShichosonDac;

    private static final RString 表示対象 = new RString("1");

    /**
     * InstanceProviderを用いてDacのインスタンスを生成し、メンバ変数に保持します。
     */
    public GappeiShichosonFinder() {
        gappeiJohoDac = InstanceProvider.create(GappeiJohoDac.class);
        gappeiShichosonDac = InstanceProvider.createWithCustomize(GappeiShichosonDac.class);
        koseiShichosonDac = InstanceProvider.createWithCustomize(KoseiShichosonMasterDac.class);
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param gappeiJohoDac 合併情報Dac
     * @param gappeiShichosonDac 合併市町村Dac
     * @param koseiShichosonDac 構成市町村Dac
     */
    GappeiShichosonFinder(
            GappeiJohoDac gappeiJohoDac,
            GappeiShichosonDac gappeiShichosonDac,
            KoseiShichosonMasterDac koseiShichosonDac) {
        this.gappeiJohoDac = gappeiJohoDac;
        this.gappeiShichosonDac = gappeiShichosonDac;
        this.koseiShichosonDac = koseiShichosonDac;
    }

    @Override
    public boolean is合併あり() {

        // TODO
        // 「コンフィグ.合併市町村管理_合併情報区分」の設定に従って、以下の処理を行う。
        // 「0：合併なし」の場合、falseを返す。
        // 「1：合併あり」の場合、trueを返す。
        //
        return true;
    }

    @Override
    public FlexibleDate get旧市町村情報付与終了日() {

        // TODO
        // 最新の合併情報を取得し、旧市町村情報付与終了日を返却する。
        //
        IGappeiJoho gappeiJoho = new GappeiJohoCollection(gappeiJohoDac.selectAll()).getLatest();
        return gappeiJoho != null ? gappeiJoho.get旧市町村情報付与終了日() : null;
    }

    @Override
    public GappeiShichosonJohoCollection get全合併市町村(boolean 表示対象のみ) {

        // TODO
        // 合併ありかどうかを判定する。
        // 　　「合併なし」の場合は、空のリストを返却する。
        // 　　「合併あり」の場合は、以降の処理を継続する。
        // 全合併情報を取得する。
        // 取得した合併情報分、以下の処理を行う。
        // 　　取得した合併情報が含む合併市町村情報を取得する。
        // 　　引数の表示フラグがtrueの場合は、表示対象のデータのみを対象とし、falseの場合は、全てのデータを対象とする。
        // 　　合併情報と合併市町村情報を合わせて返却値のリストに追加する。
        // 作成したリストを返却する。
        //
        if (!is合併あり()) {
            return new GappeiShichosonJohoCollection(Collections.EMPTY_LIST);
        }
        List<IGappeiShichosonJoho> 合併市町村情報リスト = new ArrayList<>();
        List<IGappeiJoho> 合併情報リスト = gappeiJohoDac.selectAll();
        for (IGappeiJoho 合併情報 : 合併情報リスト) {
            ITrueFalseCriteria searchKey = makeSearchKeyBy地域番号For合併市町村(合併情報.get地域番号(), 表示対象のみ);
            List<IGappeiShichoson> 合併市町村リスト = gappeiShichosonDac.select(searchKey);
            合併市町村情報リスト.add(new GappeiShichosonJohoModel(合併情報, 合併市町村リスト));
        }
        return new GappeiShichosonJohoCollection(合併市町村情報リスト);
    }

    @Override
    public GappeiShichosonCollection get全旧市町村() {

        // TODO
        // 全合併市町村情報を取得する。
        // 取得した合併市町村情報の中に旧市町村コードが同一の情報がある場合は、最新の情報のみを対象とする。
        // 取得した合併市町村情報のリストを返却する。
        //
        List<IGappeiShichoson> 合併市町村リスト = gappeiShichosonDac.selectAll();
        return new GappeiShichosonCollection(合併市町村リスト).getLatestList();
    }

    @Override
    public GappeiShichosonJohoCollection find合併市町村(ISearchCondition 検索条件, boolean 表示対象のみ) {

        // TODO
        // 合併市町村かどうかを判定する。
        // 　　「合併なし」の場合は、空のリストを返却する。
        // 　　「合併あり」の場合は、以降の処理を継続する。
        // 引数の検索条件に該当する合併情報を取得する。
        // 取得した合併情報分、以下の処理を行う。
        // 　　合併情報が含む合併市町村情報を取得する。
        // 　　引数の表示フラグがtrueの場合は、表示対象のデータのみを対象とし、falseの場合は、全てのデータを対象とする。
        // 　　合併情報と合併市町村情報を合わせて返却値のリストに追加する。
        // 作成したリストを返却する。
        //
        if (!is合併あり()) {
            return new GappeiShichosonJohoCollection(Collections.EMPTY_LIST);
        }
        List<IGappeiShichosonJoho> 合併市町村情報リスト = new ArrayList<>();
        List<IGappeiJoho> 合併情報リスト = gappeiJohoDac.select(検索条件.makeSearchCondition());
        for (IGappeiJoho 合併情報 : 合併情報リスト) {
            ITrueFalseCriteria searchKey = makeSearchKeyBy地域番号For合併市町村(合併情報.get地域番号(), 表示対象のみ);
            List<IGappeiShichoson> 合併市町村リスト = gappeiShichosonDac.select(searchKey);
            合併市町村情報リスト.add(new GappeiShichosonJohoModel(合併情報, 合併市町村リスト));
        }
        return new GappeiShichosonJohoCollection(合併市町村情報リスト);
    }

    @Override
    public KoikiGappeiShichosonJohoCollection get全広域合併市町村(boolean 表示対象のみ) {

        // TODO
        // 合併ありかどうかを判定する。
        // 　　「合併なし」の場合は、空のリストを返却する。
        // 　　「合併あり」の場合は、以降の処理を継続する。
        // 全合併情報を取得する。
        // 取得した合併情報分、以下の処理を行う。
        // 　　合併情報が含む構成市町村情報を取得する。
        // 　　引数の表示フラグがtrueの場合は、表示対象のデータのみを対象とし、falseの場合は、全てのデータを対象とする。
        // 　　合併情報と構成市町村情報を合わせて返却値のリストに追加する。
        // 作成したリストを返却する。
        //
        if (!is合併あり()) {
            return new KoikiGappeiShichosonJohoCollection(Collections.EMPTY_LIST);
        }
        List<IKoikiGappeiShichosonJoho> 広域合併市町村情報リスト = new ArrayList<>();
        List<IGappeiJoho> 合併情報リスト = gappeiJohoDac.selectAll();
        for (IGappeiJoho 合併情報 : 合併情報リスト) {
            ITrueFalseCriteria searchKey = makeSearchKeyBy地域番号For構成市町村(合併情報.get地域番号(), 表示対象のみ);
            List<IKoikiKoseiShichoson> 広域構成市町村リスト = koseiShichosonDac.select(searchKey);
            広域合併市町村情報リスト.add(new KoikiGappeiShichosonJohoModel(合併情報, 広域構成市町村リスト));
        }
        return new KoikiGappeiShichosonJohoCollection(広域合併市町村情報リスト);
    }

    @Override
    public KoikiGappeiShichosonJohoCollection get地域ごとの最新広域合併市町村() {

        // TODO
        // 地域数分、以下の処理を行う。
        // 　　最新の合併情報を取得する。
        // 　　取得した合併情報の市町村コードに該当する構成市町村情報を取得する。
        // 　　合併情報と構成市町村情報を合わせて返却値のリストに追加する。
        // 作成したリストを返却する。
        //
        List<IKoikiGappeiShichosonJoho> 広域合併市町村情報リスト = new ArrayList<>();
        GappeiJohoCollection 合併情報リスト = new GappeiJohoCollection(gappeiJohoDac.selectAll());
        for (IGappeiJoho 合併情報 : 合併情報リスト.getLatestList()) {
            ITrueFalseCriteria searchKey = makeSearchKeyBy市町村コードFor構成市町村(合併情報.get市町村コード());
            IKoikiKoseiShichoson 広域構成市町村 = new KoikiKoseiShichosons(koseiShichosonDac.select(searchKey)).getLatest();
            List<IKoikiKoseiShichoson> 広域構成市町村リスト = new ArrayList<>();
            広域構成市町村リスト.add(広域構成市町村);
            広域合併市町村情報リスト.add(new KoikiGappeiShichosonJohoModel(合併情報, 広域構成市町村リスト));
        }
        return new KoikiGappeiShichosonJohoCollection(広域合併市町村情報リスト);
    }

    @Override
    public IKoikiGappeiShichosonJoho get地域ごとの広域合併市町村(RString 合併後の市町村コード) {

        // TODO
        // 引数の市町村コードに該当する最新の合併情報を取得する。
        // 取得した合併情報が含む構成市町村情報を取得する。
        // 合併情報と構成市町村情報を合わせて返却する。
        //
        ITrueFalseCriteria searchKey = makeSearchKeyBy市町村コードFor合併情報(合併後の市町村コード);
        IGappeiJoho 合併情報 = new GappeiJohoCollection(gappeiJohoDac.select(searchKey)).getLatest();
        if (合併情報 == null) {
            return null;
        }
        searchKey = makeSearchKeyBy地域番号For構成市町村(合併情報.get地域番号(), false);
        List<IKoikiKoseiShichoson> 広域構成市町村リスト = koseiShichosonDac.select(searchKey);
        return new KoikiGappeiShichosonJohoModel(合併情報, 広域構成市町村リスト);
    }

    @Override
    public KoikiGappeiShichosonJohoCollection get全地域の広域合併市町村() {

        // TODO
        // 地域数分、以下の処理を行う。
        // 　　最新の合併情報を取得する。
        // 　　取得した合併情報が含む構成市町村情報を取得する。
        // 　　合併情報と構成市町村情報を合わせて返却値のリストに追加する。
        // 作成したリストを返却する。
        //
        List<IKoikiGappeiShichosonJoho> 広域合併市町村情報リスト = new ArrayList<>();
        GappeiJohoCollection 合併情報リスト = new GappeiJohoCollection(gappeiJohoDac.selectAll());
        for (IGappeiJoho 合併情報 : 合併情報リスト.getLatestList()) {
            ITrueFalseCriteria searchKey = makeSearchKeyBy地域番号For構成市町村(合併情報.get地域番号(), false);
            List<IKoikiKoseiShichoson> 広域構成市町村リスト = koseiShichosonDac.select(searchKey);
            広域合併市町村情報リスト.add(new KoikiGappeiShichosonJohoModel(合併情報, 広域構成市町村リスト));
        }
        return new KoikiGappeiShichosonJohoCollection(広域合併市町村情報リスト);
    }

    @Override
    public KoikiGappeiShichosonJohoCollection find広域合併市町村(ISearchCondition 検索条件) {

        // TODO
        // 引数の検索条件に該当する合併情報を取得する。
        // 取得した合併情報分、以下の処理を行う。
        // 　　合併情報が含む構成市町村情報を取得する。
        // 　　合併情報と構成市町村情報を合わせて返却値のリストに追加する。
        // 作成したリストを返却する。
        //
        if (!is合併あり()) {
            return new KoikiGappeiShichosonJohoCollection(Collections.EMPTY_LIST);
        }
        List<IKoikiGappeiShichosonJoho> 広域合併市町村情報リスト = new ArrayList<>();
        List<IGappeiJoho> 合併情報リスト = gappeiJohoDac.select(検索条件.makeSearchCondition());
        for (IGappeiJoho 合併情報 : 合併情報リスト) {
            ITrueFalseCriteria searchKey = makeSearchKeyBy地域番号For構成市町村(合併情報.get地域番号(), false);
            List<IKoikiKoseiShichoson> 広域構成市町村リスト = koseiShichosonDac.select(searchKey);
            広域合併市町村情報リスト.add(new KoikiGappeiShichosonJohoModel(合併情報, 広域構成市町村リスト));
        }
        return new KoikiGappeiShichosonJohoCollection(広域合併市町村情報リスト);
    }

    @Override
    public IKoikiGappeiShichosonJoho find広域合併市町村By合併後市町村コード(RString 合併後の市町村コード) {

        // TODO
        // 引数の市町村コードに該当する最新の構成市町村情報を取得する。
        // 取得した構成市町村情報を含む最新の合併情報を取得する。
        // 取得した合併情報と構成市町村を合わせて返却する。
        //
        ITrueFalseCriteria searchKey = makeSearchKeyBy市町村コードFor構成市町村(合併後の市町村コード);
        IKoikiKoseiShichoson 広域構成市町村 = new KoikiKoseiShichosons(koseiShichosonDac.select(searchKey)).getLatest();
        if (広域構成市町村 == null) {
            return null;
        }
        searchKey = makeSearchKeyBy地域番号For合併情報(広域構成市町村.get合併情報地域番号());
        IGappeiJoho 合併情報 = new GappeiJohoCollection(gappeiJohoDac.select(searchKey)).getLatest();
        List<IKoikiKoseiShichoson> 広域構成市町村リスト = new ArrayList<>();
        広域構成市町村リスト.add(広域構成市町村);
        return new KoikiGappeiShichosonJohoModel(合併情報, 広域構成市町村リスト);
    }

    @Override
    public IKoikiGappeiShichosonJoho find広域合併市町村By合併元市町村コード(RString 合併元の市町村コード) {

        // TODO
        // 引数の市町村コードに該当する最古の構成市町村情報を取得する。
        // 取得した構成市町村情報を含む最新の合併情報を取得する。
        // 合併情報と構成市町村情報を合わせて返却する。
        //
        ITrueFalseCriteria searchKey = makeSearchKeyBy市町村コードFor構成市町村(合併元の市町村コード);
        IKoikiKoseiShichoson 広域構成市町村 = new KoikiKoseiShichosons(koseiShichosonDac.select(searchKey)).getOldest();
        if (広域構成市町村 == null) {
            return null;
        }
        searchKey = makeSearchKeyBy地域番号For合併情報(広域構成市町村.get合併情報地域番号());
        IGappeiJoho 合併情報 = new GappeiJohoCollection(gappeiJohoDac.select(searchKey)).getLatest();
        List<IKoikiKoseiShichoson> 広域構成市町村リスト = new ArrayList<>();
        広域構成市町村リスト.add(広域構成市町村);
        return new KoikiGappeiShichosonJohoModel(合併情報, 広域構成市町村リスト);
    }

    private ITrueFalseCriteria makeSearchKeyBy地域番号For合併情報(RString 地域番号) {
        INewSearchCondition 地域番号条件 = SearchConditionFactory.condition(
                GappeiJohoSearchItem.地域番号, StringOperator.完全一致, 地域番号);
        return 地域番号条件.makeSearchCondition();
    }

    private ITrueFalseCriteria makeSearchKeyBy市町村コードFor合併情報(RString 市町村コード) {
        INewSearchCondition 市町村コード条件 = SearchConditionFactory.condition(
                GappeiJohoSearchItem.市町村コード, StringOperator.完全一致, 市町村コード);
        return 市町村コード条件.makeSearchCondition();
    }

    private ITrueFalseCriteria makeSearchKeyBy地域番号For合併市町村(RString 地域番号, boolean 表示対象のみ) {
        INewSearchCondition 地域番号条件 = SearchConditionFactory.condition(
                GappeiShichosonSearchItem.地域番号, StringOperator.完全一致, 地域番号);
        INewSearchCondition 表示有無条件 = SearchConditionFactory.condition(
                GappeiShichosonSearchItem.表示有無, StringOperator.完全一致, 表示対象);
        return 表示対象のみ ? 地域番号条件.and(表示有無条件).makeSearchCondition() : 地域番号条件.makeSearchCondition();
    }

    private ITrueFalseCriteria makeSearchKeyBy地域番号For構成市町村(RString 地域番号, boolean 表示対象のみ) {
        INewSearchCondition 地域番号条件 = SearchConditionFactory.condition(
                KoseiShichosonMasterSearchItem.合併情報地域番号, StringOperator.完全一致, 地域番号);
        INewSearchCondition 表示有無条件 = SearchConditionFactory.condition(
                KoseiShichosonMasterSearchItem.合併旧市町村表示有無, StringOperator.完全一致, 表示対象);
        return 表示対象のみ ? 地域番号条件.and(表示有無条件).makeSearchCondition() : 地域番号条件.makeSearchCondition();
    }

    private ITrueFalseCriteria makeSearchKeyBy市町村コードFor構成市町村(RString 市町村コード) {
        INewSearchCondition 地域番号条件 = SearchConditionFactory.condition(
                KoseiShichosonMasterSearchItem.市町村コード, StringOperator.完全一致, 市町村コード);
        return 地域番号条件.makeSearchCondition();
    }
}
