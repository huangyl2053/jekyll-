/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB6110001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.rentainofugimusha.AtenaJouhou;
import jp.co.ndensan.reams.db.dbb.business.core.rentainofugimusha.RentaiGimushaAtenaJouhou;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001.KaigoHihokenshaInfoPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001.dgRentaiNofuGimushaIchiran_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001.dgSetaiIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 連帯納付義務者登録Handlerです。
 *
 * @reamsid_L DBB-1640-010 jiangzongyue
 */
public class KaigoHihokenshaInfoPanelHandler {

    private final KaigoHihokenshaInfoPanelDiv div;
    private static final RString 被保険者番号R = new RString("被保険者番号");
    private static final Code THREE = new Code("0003");
    private static final RString CODE_003 = new RString("003");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString DB = new RString("DB");
    private static final RString 名称_被保険者番号 = new RString("被保険者番号");

    /**
     * コンストラクタです。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     */
    public KaigoHihokenshaInfoPanelHandler(KaigoHihokenshaInfoPanelDiv div) {
        this.div = div;
    }

    /**
     * onLoad時アクセスログ出力します。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     */
    public void printLog識別コード照会(ShikibetsuCode 識別コード, RString 被保険者番号) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号));
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(THREE, 被保険者番号R, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo);
    }

    /**
     * 初期化のメソッドです。
     *
     * @param taishoshaKey TaishoshaKey
     */
    public void initializeDisplay(FukaTaishoshaKey taishoshaKey) {
        div.setTxtDialog(ONE);
        div.setTxtGyomuCode(DB);
        div.setTxtSearchYusenKubun(TWO);
        div.setTxtAgeArrivalDay(ONE);
        div.getCcdKaigoAtenaInfo().initialize(taishoshaKey.get識別コード());
        KaigoFukaKihonSearchKey searchKey = new KaigoFukaKihonSearchKey.Builder(
                taishoshaKey.get通知書番号(),
                taishoshaKey.get賦課年度(),
                taishoshaKey.get市町村コード(),
                taishoshaKey.get識別コード()).build();
        div.getCcdKaigoFukaKihon().load(searchKey);
    }

    /**
     * 登録済介護保険料連帯納付義務者情報一覧を表示するのイベントです。
     *
     * @param atenaList List<AtenaJouhou>
     * @param 被保険者番号 HihokenshaNo
     */
    public void setDgSetaiIchiran(List<AtenaJouhou> atenaList, HihokenshaNo 被保険者番号) {
        List<dgSetaiIchiran_Row> rowList = new ArrayList();
        List<PersonalData> personalDataList = new ArrayList();
        for (AtenaJouhou result : atenaList) {
            dgSetaiIchiran_Row row = new dgSetaiIchiran_Row();
            row.getTxtShikibetsuCode().setValue(result.get識別コード() == null ? RString.EMPTY
                    : result.get識別コード().getColumnValue());
            row.getTxtShimei().setValue(result.get氏名() == null ? RString.EMPTY
                    : result.get氏名().getColumnValue());
            row.getTxtUmareYND().setValue(result.get生年月日() == null ? null
                    : new RDate(result.get生年月日().toString()));
            row.getTxtSeibetsu().setValue(result.get性別() == null ? RString.EMPTY
                    : Seibetsu.toValue(result.get性別()).get名称());
            if (result.get住民種別() == null || ONE.equals(result.get住民種別())) {
                row.getTxtJuminShu().setValue(RString.EMPTY);
            } else {
                row.getTxtJuminShu().setValue(JuminShubetsu.toValue(result.get住民種別()).toRString());
            }
            row.getTxtZokugara().setValue(result.get続柄() == null ? RString.EMPTY
                    : result.get続柄());
            row.getTxtSetaiCode().setValue(result.get世帯コード() == null ? RString.EMPTY
                    : result.get世帯コード().getColumnValue());
            row.getTxtJusho().setValue(result.get住所() == null ? RString.EMPTY
                    : result.get住所().getColumnValue());
            rowList.add(row);
            ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE_003),
                    名称_被保険者番号, 被保険者番号.getColumnValue());
            PersonalData personalData = PersonalData.of(result.get識別コード(), expandedInfo);
            personalDataList.add(personalData);
        }
        div.getDgSetaiIchiran().setDataSource(rowList);
        AccessLogger.log(AccessLogType.照会, personalDataList);
    }

    /**
     * 直近世帯一覧行選択を表示するのイベントです。
     *
     * @param rentaiList List<RentaiGimushaAtenaJouhou>
     * @param 被保険者番号 HihokenshaNo
     */
    public void setDgRentaiNofuGimushaIchiran(List<RentaiGimushaAtenaJouhou> rentaiList, HihokenshaNo 被保険者番号) {
        List<dgRentaiNofuGimushaIchiran_Row> rowList = new ArrayList();
        List<PersonalData> personalDataList = new ArrayList<>();
        for (RentaiGimushaAtenaJouhou result : rentaiList) {
            dgRentaiNofuGimushaIchiran_Row row = new dgRentaiNofuGimushaIchiran_Row();
            row.getTxtKaishiYMD().setValue(result.get開始日() == null ? null
                    : new RDate(result.get開始日().toString()));
            row.getTxtShuryoYMD().setValue(result.get終了日() == null ? null
                    : new RDate(result.get終了日().toString()));
            row.getTxtShikibetsuCode().setValue(result.get識別コード() == null ? RString.EMPTY
                    : result.get識別コード().getColumnValue());
            row.getTxtSetaiCode().setValue(result.get世帯コード() == null ? RString.EMPTY
                    : result.get世帯コード().getColumnValue());
            row.getTxtShimei().setValue(result.get氏名() == null ? RString.EMPTY
                    : result.get氏名().getColumnValue());
            row.getTxtUmareYMD().setValue(result.get生年月日() == null ? null
                    : new RDate(result.get生年月日().toString()));
            row.getTxtSeibetsu().setValue(result.get性別() == null ? RString.EMPTY
                    : Seibetsu.toValue(result.get性別()).get名称());
            if (result.get住民種別() == null || ONE.equals(result.get住民種別())) {
                row.getTxtJuminShu().setValue(RString.EMPTY);
            } else {
                row.getTxtJuminShu().setValue(JuminShubetsu.toValue(result.get住民種別()).toRString());
            }
            row.getTxtZokugara().setValue(result.get続柄() == null ? RString.EMPTY
                    : result.get続柄());
            row.getTxtJusho().setValue(result.get住所() == null ? RString.EMPTY
                    : result.get住所().getColumnValue());
            row.getTxtRirekiNo().setValue(new RString(result.get履歴番号()));
            rowList.add(row);
            ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE_003),
                    名称_被保険者番号, 被保険者番号.getColumnValue());
            PersonalData personalData = PersonalData.of(result.get識別コード(), expandedInfo);
            personalDataList.add(personalData);
        }
        div.getDgRentaiNofuGimushaIchiran().setDataSource(rowList);
        AccessLogger.log(AccessLogType.照会, personalDataList);
    }

    /**
     * 直近世帯一覧行選択を表示するのイベントです。
     *
     * @param row dgSetaiIchiran_Row
     */
    public void setRentaiNofuGimushaInfo(dgSetaiIchiran_Row row) {
        div.getRentaiNofuGimushaInfo().getTxtShikibetsuCode().setDomain(row.getTxtShikibetsuCode() == null ? null
                : new ShikibetsuCode(row.getTxtShikibetsuCode().getValue()));
        div.getRentaiNofuGimushaInfo().getTxtShimei().setValue(row.getTxtShimei() == null ? RString.EMPTY
                : row.getTxtShimei().getValue());
        div.getRentaiNofuGimushaInfo().getTxtUmareYMD().setValue(row.getTxtUmareYND() == null ? null
                : row.getTxtUmareYND().getValue());
        div.getRentaiNofuGimushaInfo().getTxtSeibetsu().setValue(row.getTxtSeibetsu() == null ? RString.EMPTY
                : row.getTxtSeibetsu().getValue());
        div.getRentaiNofuGimushaInfo().getTxtJuminShu().setValue(row.getTxtJuminShu() == null ? RString.EMPTY
                : row.getTxtJuminShu().getValue());
        div.getRentaiNofuGimushaInfo().getTxtZokuGara().setValue(row.getTxtZokugara() == null ? RString.EMPTY
                : row.getTxtZokugara().getValue());
        div.getRentaiNofuGimushaInfo().getTxtSetaiCode().setDomain(row.getTxtSetaiCode() == null ? null
                : new SetaiCode(row.getTxtSetaiCode().getValue()));
        div.getRentaiNofuGimushaInfo().getTxtJusho().setDomain(row.getTxtJusho() == null ? null
                : new AtenaJusho(row.getTxtJusho().getValue()));
    }

    /**
     * 直近世帯一覧行選択を表示するのイベントです。
     *
     * @param row dgRentaiNofuGimushaIchiran_Row
     */
    public void setRentaiNofuGimushaInfo(dgRentaiNofuGimushaIchiran_Row row) {
        div.getRentaiNofuGimushaInfo().getTxtKaishiYMD().setValue(row.getTxtKaishiYMD() == null ? null
                : row.getTxtKaishiYMD().getValue());
        div.getRentaiNofuGimushaInfo().getTxtShuryoYMD().setValue(row.getTxtShuryoYMD() == null ? null
                : row.getTxtShuryoYMD().getValue());
        div.getRentaiNofuGimushaInfo().getTxtShikibetsuCode().setDomain(row.getTxtShikibetsuCode() == null ? null
                : new ShikibetsuCode(row.getTxtShikibetsuCode().getValue()));
        div.getRentaiNofuGimushaInfo().getTxtSetaiCode().setDomain(row.getTxtSetaiCode() == null ? null
                : new SetaiCode(row.getTxtSetaiCode().getValue()));
        div.getRentaiNofuGimushaInfo().getTxtShimei().setValue(row.getTxtShimei() == null ? RString.EMPTY
                : row.getTxtShimei().getValue());
        div.getRentaiNofuGimushaInfo().getTxtUmareYMD().setValue(row.getTxtUmareYMD() == null ? null
                : row.getTxtUmareYMD().getValue());
        div.getRentaiNofuGimushaInfo().getTxtSeibetsu().setValue(row.getTxtSeibetsu() == null ? RString.EMPTY
                : row.getTxtSeibetsu().getValue());
        div.getRentaiNofuGimushaInfo().getTxtJuminShu().setValue(row.getTxtJuminShu() == null ? RString.EMPTY
                : row.getTxtJuminShu().getValue());
        div.getRentaiNofuGimushaInfo().getTxtZokuGara().setValue(row.getTxtZokugara() == null ? RString.EMPTY
                : row.getTxtZokugara().getValue());
        div.getRentaiNofuGimushaInfo().getTxtJusho().setDomain(row.getTxtJusho() == null ? null
                : new AtenaJusho(row.getTxtJusho().getValue()));
        div.getRentaiNofuGimushaInfo().getTxtRirekiNo().setValue(row.getTxtRirekiNo().getValue());
    }

    /**
     * 直近世帯一覧表示するのイベントです。
     *
     * @param list List<RentaiGimushaAtenaJouhou>
     */
    public void set直近世帯情報取得(List<AtenaJouhou> list) {
        List<dgSetaiIchiran_Row> rowList = new ArrayList();
        for (AtenaJouhou result : list) {
            dgSetaiIchiran_Row row = new dgSetaiIchiran_Row();
            row.getTxtShikibetsuCode().setValue(result.get識別コード() == null ? RString.EMPTY
                    : result.get識別コード().getColumnValue());
            row.getTxtShimei().setValue(result.get氏名() == null ? RString.EMPTY
                    : result.get氏名().getColumnValue());
            row.getTxtUmareYND().setValue(result.get生年月日() == null ? null
                    : new RDate(result.get生年月日().toString()));
            row.getTxtSeibetsu().setValue(result.get性別() == null ? RString.EMPTY
                    : result.get性別());
            row.getTxtJuminShu().setValue(result.get住民種別() == null ? RString.EMPTY
                    : result.get住民種別());
            row.getTxtZokugara().setValue(result.get続柄() == null ? RString.EMPTY
                    : result.get続柄());
            row.getTxtSetaiCode().setValue(result.get世帯コード() == null ? RString.EMPTY
                    : result.get世帯コード().getColumnValue());
            row.getTxtJusho().setValue(result.get住所() == null ? RString.EMPTY
                    : result.get住所().getColumnValue());
            rowList.add(row);
        }
        div.getDgSetaiIchiran().setDataSource(rowList);
    }
}
