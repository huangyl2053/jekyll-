/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.KagoKetteiHokenshaInMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.KagoKetteiHokenshaInShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.ShihihokenshabangoTempTableEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 過誤決定通知書情報取込（保険者分）自己作成のマッパーインタフェースです
 */
public interface IKagoKetteiHokenshaInMapper {

    void create保険者分情報_明細();

    void delete保険者分情報_明細();

    void insert保険者分情報_明細(KagoKetteiHokenshaInMeisaiEntity entity);

    List<KagoKetteiHokenshaInMeisaiEntity> get保険者分情報_明細();

    void create保険者分情報_集計();

    void delete保険者分情報_集計();

    void insert保険者分情報_集計(KagoKetteiHokenshaInShukeiEntity entity);

    List<KagoKetteiHokenshaInShukeiEntity> get保険者分情報_集計();

    void insert過誤決定明細(KagoKetteiHokenshaInMeisaiEntity entity);

    void insert過誤決定集計(KagoKetteiHokenshaInShukeiEntity entity);

    List<DbT3104KokuhorenInterfaceKanriEntity> get国保連管理情報(FlexibleYearMonth 処理年月);

    void update国保連管理(DbT3104KokuhorenInterfaceKanriEntity entity);

    void insert国保連管理(DbT3104KokuhorenInterfaceKanriEntity entity);

    List<DbT1001HihokenshaDaichoEntity> get市町村コード();

    List<ShihihokenshabangoTempTableEntity> get新被保険者番号(LasdecCode shichosonCode);

    void update保険者分情報_明細();

}
