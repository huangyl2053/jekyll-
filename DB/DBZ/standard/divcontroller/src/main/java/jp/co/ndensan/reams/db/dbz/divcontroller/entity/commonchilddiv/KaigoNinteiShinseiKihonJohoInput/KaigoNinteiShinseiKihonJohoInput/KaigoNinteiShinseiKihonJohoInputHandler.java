package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7052KoseiShichosonShishoMasterDac;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護認定申請基本情報の入力用クラスのハンドラークラスです。
 *
 * @reamsid_L DBZ-1300-070 wangxiaodong
 */
public class KaigoNinteiShinseiKihonJohoInputHandler {

    private final KaigoNinteiShinseiKihonJohoInputDiv div;
    private final DbT7052KoseiShichosonShishoMasterDac dac;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定申請基本情報の入力用DIV
     */
    public KaigoNinteiShinseiKihonJohoInputHandler(KaigoNinteiShinseiKihonJohoInputDiv div) {
        this.div = div;
        this.dac = InstanceProvider.create(DbT7052KoseiShichosonShishoMasterDac.class);
    }

    /**
     * 画面初期化表示、画面項目に設定します。
     *
     * @return ResponseData
     */
    public ResponseData initialize() {
        ResponseData<KaigoNinteiShinseiKihonJohoInputDiv> response = new ResponseData<>();
        setDataSource();
        div.getTxtShinseiYMD().setValue(RDate.getNowDate());
        response.data = div;
        return response;
    }

    /**
     *
     * 画面上のドロップダウンリストへデータソースをセットします。
     */
    private void setDataSource() {
        div.getDdlShinseiShubetsu().setDataSource(get申請種別List());
        div.getDdlShinseiKubunShinseiji().setDataSource(get申請時区分List());
        div.getDdlShinseiKubunHorei().setDataSource(get申請法令区分List());
        div.getDdlShisho().setDataSource(get支所List());
        div.getDdlHihokenshaKubun().setDataSource(get被保険者区分List());
        div.getDdlTokuteiShippei().setDataSource(get特定疾病List());
    }

    private List<KeyValueDataSource> get申請種別List() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (JukyuShinseiJiyu jukyuShinseiJiyu : JukyuShinseiJiyu.values()) {
            dataSource.add(new KeyValueDataSource(jukyuShinseiJiyu.getコード(), jukyuShinseiJiyu.get名称()));
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get申請時区分List() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (NinteiShinseiShinseijiKubunCode shinseiShinseijiCode : NinteiShinseiShinseijiKubunCode.values()) {
            dataSource.add(new KeyValueDataSource(shinseiShinseijiCode.getコード(), shinseiShinseijiCode.get名称()));
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get申請法令区分List() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (NinteiShinseiHoreiCode shinseiHoreiCode : NinteiShinseiHoreiCode.values()) {
            dataSource.add(new KeyValueDataSource(shinseiHoreiCode.getコード(), shinseiHoreiCode.get名称()));
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get支所List() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        List<DbT7052KoseiShichosonShishoMasterEntity> entity = dac.selectByShichosonCode(Association.getLasdecCode());
        for (DbT7052KoseiShichosonShishoMasterEntity 支所 : entity) {
            dataSource.add(new KeyValueDataSource(支所.getShishoCode().value(), 支所.getShishoMei()));
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get被保険者区分List() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (HihokenshaKubunCode hihokenshaKubun : HihokenshaKubunCode.values()) {
            dataSource.add(new KeyValueDataSource(hihokenshaKubun.getコード(), hihokenshaKubun.get名称()));
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get特定疾病List() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (TokuteiShippei tokuteiShippei : TokuteiShippei.values()) {
            dataSource.add(new KeyValueDataSource(tokuteiShippei.getコード(), tokuteiShippei.get名称()));
        }
        return dataSource;
    }
}
