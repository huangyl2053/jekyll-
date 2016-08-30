/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100026;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.FutanGendogakuNinteiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.HomonKaigoGenmenJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.HyojunFutanGengakuJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.ItakuKeikakuTodokedejohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.KyufugakuGengakujohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.RiyoshaFutanGenmenJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.RoreiFukushiNenkinjohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.SeikatsuHogojohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.SentoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.ShafuHojinKeigenJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.ShiharaHohoHenkojohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.ShikakujohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.ShisetsuNyutaishojohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.TokubetsuChiikiKasanGenmenJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.TokureiShisetuNyutaishojohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.TyohyoShutuRyokuYoJukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.YokaigoNinteiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100026.JukyushaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 受給者台帳Editorです。
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
public class JukyushaDaichoEditor implements IJukyushaDaichoEditor {

    private final TyohyoShutuRyokuYoJukyushaDaichoEntity 帳票出力用受給者台帳;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票出力用受給者台帳 JukyushaDaichoEntity
     */
    public JukyushaDaichoEditor(TyohyoShutuRyokuYoJukyushaDaichoEntity 帳票出力用受給者台帳) {
        this.帳票出力用受給者台帳 = 帳票出力用受給者台帳;

    }

    @Override
    public JukyushaDaichoReportSource edit(JukyushaDaichoReportSource source) {

        setSentoStep1(source);
        setYokaigoNinteiLower(source);
        setFutanGendogakuNintei(source);
        setShaFukuKeigen(source);
        setRiyoshaFutanGenmen(source);
        setHoumonKaigoRiyoshaFutanGengaku(source);
        setHyojunFutanGengaku(source);
        setTokubetsuChiikiKasanGenmen(source);
        setShisetsuNyutaisho(source);
        setKyotakuKeikaku(source);
        setTokureiShisetsuNyutaisho(source);
        setShiharaiHohoHenko(source);
        setKyufugakuGengaku(source);
        setShikaku(source);
        setRoreiFukushiNenkin(source);
        setSeikatsuHogo(source);
        setSentoStep2(source);
        return source;
    }

    private void setSentoStep1(JukyushaDaichoReportSource source) {
        source.printTimeStamp = get印刷日時();
        List<YokaigoNinteiJohoEntity> 要介護認定情報EntityList = this.帳票出力用受給者台帳.get要介護認定情報EntityList();
        for (int yokaigoIndex = 0; yokaigoIndex < 要介護認定情報EntityList.size(); yokaigoIndex++) {
            if (要介護認定情報EntityList.get(yokaigoIndex).get先頭Entity() != null) {
                SentoEntity 先頭Entity = 要介護認定情報EntityList.get(yokaigoIndex).get先頭Entity();
                source.hokenshaNo = 先頭Entity.get保険者番号();
                source.hokenshaName = 先頭Entity.get保険者名称();
                source.shoHokenshaNo = 先頭Entity.get証記載保険者コード();
                source.shoHokenshaName = 先頭Entity.get証記載保険者名();
                source.hihokenshaPage = 先頭Entity.get被保険者に対するページ();
                source.totalPage = 先頭Entity.get総ページ();
                source.hihokenshaNo = 先頭Entity.get被保険者番号();
                source.hiHokenshaName = 先頭Entity.get被保険者名();
                source.hihokenshaNameKana = 先頭Entity.get被保険者名カナ();
                source.seibetsu = 先頭Entity.get性別();
                source.birthYMD = 先頭Entity.get生年月日().wareki().toDateString();
                source.hihokenshaJushoCode = 先頭Entity.get住所コード();
                source.hihokenshaJusho = 先頭Entity.get住所();
                source.setaiCode = 先頭Entity.get世帯コード();
                source.shikibetsuCode = 先頭Entity.get住所コード();
                source.genJotai = 先頭Entity.get現状態();
                source.gyoseikuCode = 先頭Entity.get行政区コード();
                source.gyoseikuName = 先頭Entity.get行政区名称();
                source.telTitle1 = 先頭Entity.get連絡先区分1();
                source.telNo1 = 先頭Entity.get連絡先1();
                source.telTitle2 = 先頭Entity.get連絡先区分2();
                source.telNo2 = 先頭Entity.get連絡先2();
                source.rokenCityCode = 先頭Entity.get老健市町村コード();
                source.rokenCityName = 先頭Entity.get老健市町村名称();
                source.rokenJukyuCode = 先頭Entity.get老健受給者番号();
                source.sonotaTitle1 = 先頭Entity.get地区タイトル1();
                source.sonotaTitle2 = 先頭Entity.get地区タイトル2();
                source.sonotaTitle3 = 先頭Entity.get地区タイトル3();
                source.chikuCode1 = 先頭Entity.get地区コード1();
                source.chikuCode2 = 先頭Entity.get地区コード2();
                source.chikuCode3 = 先頭Entity.get地区コード3();
            }
        }
    }

    private void setYokaigoNinteiLower(JukyushaDaichoReportSource source) {
        List<YokaigoNinteiJohoEntity> 要介護認定情報EntityList = this.帳票出力用受給者台帳.get要介護認定情報EntityList();
        if (要介護認定情報EntityList != null && !要介護認定情報EntityList.isEmpty()) {
            for (int yokaigoIndex = 0; yokaigoIndex < 要介護認定情報EntityList.size(); yokaigoIndex++) {
                YokaigoNinteiJohoEntity 要介護認定情報Entity = 要介護認定情報EntityList.get(yokaigoIndex);
                source.listNinteiLower_1 = 要介護認定情報Entity.get認定区分();
                source.listNinteiLower_2 = 要介護認定情報Entity.get明細番号();
                source.listNinteiLower_3 = 要介護認定情報Entity.get認定申請日().wareki().toDateString();
                source.listNinteiLower_4 = 要介護認定情報Entity.get認定日().wareki().toDateString();
                source.listNinteiLower_5 = 要介護認定情報Entity.get申請事由();
                source.listNinteiLower_6 = 要介護認定情報Entity.get異動事由();
                source.listNinteiLower_7 = 要介護認定情報Entity.get要介護度();
                source.listNinteiLower_8 = 要介護認定情報Entity.get認定開始日().wareki().toDateString();
                source.listNinteiLower_9 = 要介護認定情報Entity.get認定終了日().wareki().toDateString();
                source.listNinteiLower_10 = new RString(要介護認定情報Entity.get訪問限度額().toString());
                source.listNinteiLower_11 = 要介護認定情報Entity.get訪問開始日().wareki().toDateString();
                source.listNinteiLower_12 = 要介護認定情報Entity.get訪問終了日().wareki().toDateString();
                source.listNinteiLower_13 = new RString(要介護認定情報Entity.get短期限度額().toString());
                //TODO ReportSourceに、これらの内容がない
//                source.listNinteiLower_14 = 要介護認定情報Entity.get短期開始日().wareki().toDateString();
//                source.listNinteiLower_15 = 要介護認定情報Entity.get短期終了日().wareki().toDateString();
//                source.listNinteiLower_16 = 要介護認定情報Entity.get調査依頼日().wareki().toDateString();
//                source.listNinteiLower_17 = 要介護認定情報Entity.get調査予定日().wareki().toDateString();
//                source.listNinteiLower_18 = 要介護認定情報Entity.get調査実施日().wareki().toDateString();
//                source.listNinteiLower_19 = 要介護認定情報Entity.get医師依頼日().wareki().toDateString();
//                source.listNinteiLower_20 = 要介護認定情報Entity.get医師予定日().wareki().toDateString();
//                source.listNinteiLower_21 = 要介護認定情報Entity.get医師取寄日().wareki().toDateString();
//                source.listNinteiLower_22 = 要介護認定情報Entity.get資料作成日().wareki().toDateString();
//                source.listNinteiLower_23 = 要介護認定情報Entity.get審査予定日().wareki().toDateString();
//                source.listNinteiLower_24 = 要介護認定情報Entity.get二次判定日().wareki().toDateString();
//                source.listNinteiLower_25 = 要介護認定情報Entity.get一次要介護度();
//                source.listNinteiLower_26 = 要介護認定情報Entity.get一次判定日().wareki().toDateString();
//                source.listNinteiLower_27 = 要介護認定情報Entity.get一次要介護度_重();
//                source.listNinteiLower_28 = 要介護認定情報Entity.get旧措置().get名称();
//                source.listNinteiLower_29 = 要介護認定情報Entity.get喪失日().wareki().toDateString();
//                source.listNinteiLower_30 = 要介護認定情報Entity.get資格取得前申請();
//                source.listNinteiLower_31 = 要介護認定情報Entity.get延期通知書発行日().wareki().toDateString();
//                source.listNinteiLower_32 = 要介護認定情報Entity.get延期通知書発行回数();
//                source.listNinteiLower_33 = 要介護認定情報Entity.get資格証明書発行日１().wareki().toDateString();
//                source.listNinteiLower_34 = 要介護認定情報Entity.get資格証明書発行日２().wareki().toDateString();
//                source.listNinteiLower_35 = 要介護認定情報Entity.get特定疾病();
//                source.listNinteiLower_36 = 要介護認定情報Entity.get申請代行事業者();
//                source.listNinteiLower_37 = 要介護認定情報Entity.get代行者コード().get名称();
//                source.listNinteiLower_38 = 要介護認定情報Entity.get指定医区分();
//                source.listNinteiLower_39 = 要介護認定情報Entity.get調査委託先コード();
//                source.listNinteiLower_40 = 要介護認定情報Entity.get調査委託先名();
//                source.listNinteiLower_41 = 要介護認定情報Entity.get調査員コード();
//                source.listNinteiLower_42 = 要介護認定情報Entity.get調査員名();
//                source.listNinteiLower_43 = 要介護認定情報Entity.get主治医医療機関コード();
//                source.listNinteiLower_44 = 要介護認定情報Entity.get主治医医療機関名();
//                source.listNinteiLower_45 = 要介護認定情報Entity.get主治医コード();
//                source.listNinteiLower_46 = 要介護認定情報Entity.get主治医名();
//                source.listNinteiLower_47 = 要介護認定情報Entity.get認定審査会意見();
//                source.listNinteiLower_48 = 要介護認定情報Entity.get申請区分_申請時();
//                source.listNinteiLower_49 = 要介護認定情報Entity.get申請区分_法令();
            }
        }
    }

    private void setFutanGendogakuNintei(JukyushaDaichoReportSource source) {
        List<FutanGendogakuNinteiJohoEntity> 負担限度額認定情報EntityList = this.帳票出力用受給者台帳.get負担限度額認定情報EntityList();
        if (負担限度額認定情報EntityList != null && !負担限度額認定情報EntityList.isEmpty()) {
            for (int futanIndex = 0; futanIndex < 負担限度額認定情報EntityList.size(); futanIndex++) {
                FutanGendogakuNinteiJohoEntity 負担限度額認定情報Entity = 負担限度額認定情報EntityList.get(futanIndex);
                source.listFutanGendogakuNintei_1 = 負担限度額認定情報Entity.get負担限度額認定区分();
                source.listFutanGendogakuNintei_2 = 負担限度額認定情報Entity.get明細番号();
                source.listFutanGendogakuNintei_3 = 負担限度額認定情報Entity.get申請年月日().wareki().toDateString();
                source.listFutanGendogakuNintei_4 = 負担限度額認定情報Entity.get申請理由();
                source.listFutanGendogakuNintei_5 = 負担限度額認定情報Entity.get決定年月日().wareki().toDateString();
                source.listFutanGendogakuNintei_6 = 負担限度額認定情報Entity.get適用年月日().wareki().toDateString();
                source.listFutanGendogakuNintei_7 = 負担限度額認定情報Entity.get有効期限().wareki().toDateString();
                source.listFutanGendogakuNintei_8 = 負担限度額認定情報Entity.get負担段階();
                source.listFutanGendogakuNintei_9 = 負担限度額認定情報Entity.get旧措置();
                source.listFutanGendogakuNintei_10 = 負担限度額認定情報Entity.get居室種別();
                source.listFutanGendogakuNintei_11 = new RString(負担限度額認定情報Entity.get食費().toString());
                source.listFutanGendogakuNintei_12 = new RString(負担限度額認定情報Entity.getユ個().toString());
                source.listFutanGendogakuNintei_13 = new RString(負担限度額認定情報Entity.getユ準().toString());
                source.listFutanGendogakuNintei_14 = new RString(負担限度額認定情報Entity.get従特養().toString());
                source.listFutanGendogakuNintei_15 = new RString(負担限度額認定情報Entity.get従老健().toString());
                source.listFutanGendogakuNintei_16 = new RString(負担限度額認定情報Entity.get多床().toString());
                source.listFutanGendogakuNintei_17 = 負担限度額認定情報Entity.get境界層();
                //TODO ReportSourceに、この内容がない
//                source.listFutanGendogakuNintei_18 = 負担限度額認定情報Entity.get激変緩和();
            }
        }
    }

    private void setShaFukuKeigen(JukyushaDaichoReportSource source) {
        List<ShafuHojinKeigenJohoEntity> 社福法人軽減情報EntityList = this.帳票出力用受給者台帳.get社福法人軽減情報EntityList();
        if (社福法人軽減情報EntityList != null && !社福法人軽減情報EntityList.isEmpty()) {
            for (int shaFukuIndex = 0; shaFukuIndex < 社福法人軽減情報EntityList.size(); shaFukuIndex++) {
                ShafuHojinKeigenJohoEntity 社福法人軽減情報Entity = 社福法人軽減情報EntityList.get(shaFukuIndex);
                source.listShaFukuKeigen_1 = 社福法人軽減情報Entity.get社福軽減区分();
                source.listShaFukuKeigen_2 = 社福法人軽減情報Entity.get明細番号();
                source.listShaFukuKeigen_3 = 社福法人軽減情報Entity.get減免申請日().wareki().toDateString();
                source.listShaFukuKeigen_4 = 社福法人軽減情報Entity.get減免決定日().wareki().toDateString();
                source.listShaFukuKeigen_5 = 社福法人軽減情報Entity.get減免開始日().wareki().toDateString();
                source.listShaFukuKeigen_6 = 社福法人軽減情報Entity.get減免終了日().wareki().toDateString();
                source.listShaFukuKeigen_7 = 社福法人軽減情報Entity.get確認番号();
                source.listShaFukuKeigen_8 = 社福法人軽減情報Entity.get軽減率();
                source.listShaFukuKeigen_9 = 社福法人軽減情報Entity.get居宅限定();
                source.listShaFukuKeigen_10 = 社福法人軽減情報Entity.get居_食限定();
                //TODO ReportSourceに、この内容がない
//                source.listShaFukuKeigen_11 = 社福法人軽減情報Entity.get旧措限定();
            }
        }
    }

    private void setRiyoshaFutanGenmen(JukyushaDaichoReportSource source) {
        List<RiyoshaFutanGenmenJohoEntity> 利用者負担減免情報EntityList = this.帳票出力用受給者台帳.get利用者負担減免情報EntityList();
        if (利用者負担減免情報EntityList != null && !利用者負担減免情報EntityList.isEmpty()) {
            for (int riyoshaIndex = 0; riyoshaIndex < 利用者負担減免情報EntityList.size(); riyoshaIndex++) {
                RiyoshaFutanGenmenJohoEntity 利用者負担減免情報Entity = 利用者負担減免情報EntityList.get(riyoshaIndex);
                source.listRiyoshaFutanGenmen_1 = 利用者負担減免情報Entity.get利用者負担減免区分();
                source.listRiyoshaFutanGenmen_2 = 利用者負担減免情報Entity.get明細番号();
                source.listRiyoshaFutanGenmen_3 = 利用者負担減免情報Entity.get減免申請日().wareki().toDateString();
                source.listRiyoshaFutanGenmen_4 = 利用者負担減免情報Entity.get減免決定日().wareki().toDateString();
                source.listRiyoshaFutanGenmen_5 = 利用者負担減免情報Entity.get減免開始日().wareki().toDateString();
                source.listRiyoshaFutanGenmen_6 = 利用者負担減免情報Entity.get減免終了日().wareki().toDateString();
                //TODO ReportSourceに、この内容がない
//                source.listRiyoshaFutanGenmen_7 = 利用者負担減免情報Entity.get給付率();
            }
        }
    }

    private void setHoumonKaigoRiyoshaFutanGengaku(JukyushaDaichoReportSource source) {
        List<HomonKaigoGenmenJohoEntity> 訪問介護等減額情報EntityList = this.帳票出力用受給者台帳.get訪問介護等減額情報EntityList();
        if (訪問介護等減額情報EntityList != null && !訪問介護等減額情報EntityList.isEmpty()) {
            for (int houmonIndex = 0; houmonIndex < 訪問介護等減額情報EntityList.size(); houmonIndex++) {
                HomonKaigoGenmenJohoEntity 訪問介護等減額情報Entity = 訪問介護等減額情報EntityList.get(houmonIndex);
                source.listHonmonKaigoRiyoshaFutanGengaku_1 = 訪問介護等減額情報Entity.get訪問介護利用者負担減額区分();
                source.listHonmonKaigoRiyoshaFutanGengaku_2 = 訪問介護等減額情報Entity.get明細番号();
                source.listHonmonKaigoRiyoshaFutanGengaku_3 = 訪問介護等減額情報Entity.get減免申請日().wareki().toDateString();
                source.listHonmonKaigoRiyoshaFutanGengaku_4 = 訪問介護等減額情報Entity.get減免決定日().wareki().toDateString();
                source.listHonmonKaigoRiyoshaFutanGengaku_5 = 訪問介護等減額情報Entity.get減免開始日().wareki().toDateString();
                source.listHonmonKaigoRiyoshaFutanGengaku_6 = 訪問介護等減額情報Entity.get減免終了日().wareki().toDateString();
                source.listHonmonKaigoRiyoshaFutanGengaku_7 = 訪問介護等減額情報Entity.get給付率();
                source.listHonmonKaigoRiyoshaFutanGengaku_8 = 訪問介護等減額情報Entity.get法別().get名称();
                //TODO ReportSourceに、この内容がない
//                source.listHonmonKaigoRiyoshaFutanGengaku_9 = 訪問介護等減額情報Entity.get受給者番号();
            }
        }
    }

    private void setHyojunFutanGengaku(JukyushaDaichoReportSource source) {
        List<HyojunFutanGengakuJohoEntity> 標準負担減額情報EntityList = this.帳票出力用受給者台帳.get標準負担減額情報EntityList();
        if (標準負担減額情報EntityList != null && !標準負担減額情報EntityList.isEmpty()) {
            for (int hyojunIndex = 0; hyojunIndex < 標準負担減額情報EntityList.size(); hyojunIndex++) {
                HyojunFutanGengakuJohoEntity 標準負担減額情報Entity = 標準負担減額情報EntityList.get(hyojunIndex);
                source.listHyojunFutanGengaku_1 = 標準負担減額情報Entity.get標準負担減額区分();
                source.listHyojunFutanGengaku_2 = 標準負担減額情報Entity.get明細番号();
                source.listHyojunFutanGengaku_3 = 標準負担減額情報Entity.get減免申請日().wareki().toDateString();
                source.listHyojunFutanGengaku_4 = 標準負担減額情報Entity.get減免決定日().wareki().toDateString();
                source.listHyojunFutanGengaku_5 = 標準負担減額情報Entity.get減免開始日().wareki().toDateString();
                source.listHyojunFutanGengaku_6 = 標準負担減額情報Entity.get減免終了日().wareki().toDateString();
                //TODO ReportSourceに、この内容がない
//                source.listHyojunFutanGengaku_7 = 標準負担減額情報Entity.get負担額();
            }
        }
    }

    private void setTokubetsuChiikiKasanGenmen(JukyushaDaichoReportSource source) {
        List<TokubetsuChiikiKasanGenmenJohoEntity> 特別地域加算減免情報EntityList = this.帳票出力用受給者台帳.get特別地域加算減免情報EntityList();
        if (特別地域加算減免情報EntityList != null && !特別地域加算減免情報EntityList.isEmpty()) {
            for (int tokubetsuIndex = 0; tokubetsuIndex < 特別地域加算減免情報EntityList.size(); tokubetsuIndex++) {
                TokubetsuChiikiKasanGenmenJohoEntity 特別地域加算減免情報Entity = 特別地域加算減免情報EntityList.get(tokubetsuIndex);
                source.listTokubetsuChiikiKasanGenmen_1 = 特別地域加算減免情報Entity.get特別地域加算減免区分();
                source.listTokubetsuChiikiKasanGenmen_2 = 特別地域加算減免情報Entity.get明細番号();
                source.listTokubetsuChiikiKasanGenmen_3 = 特別地域加算減免情報Entity.get申請年月日().wareki().toDateString();
                source.listTokubetsuChiikiKasanGenmen_4 = 特別地域加算減免情報Entity.get決定年月日().wareki().toDateString();
                source.listTokubetsuChiikiKasanGenmen_5 = 特別地域加算減免情報Entity.get適用年月日().wareki().toDateString();
                source.listTokubetsuChiikiKasanGenmen_6 = 特別地域加算減免情報Entity.get有効期限().wareki().toDateString();
                source.listTokubetsuChiikiKasanGenmen_7 = 特別地域加算減免情報Entity.get減額率();
                //TODO ReportSourceに、この内容がない
//                source.listTokubetsuChiikiKasanGenmen_8 = 特別地域加算減免情報Entity.get確認番号();
            }
        }
    }

    private void setShisetsuNyutaisho(JukyushaDaichoReportSource source) {
        List<ShisetsuNyutaishojohoEntity> 施設入退所情報EntityList = this.帳票出力用受給者台帳.get施設入退所情報EntityList();
        if (施設入退所情報EntityList != null && !施設入退所情報EntityList.isEmpty()) {
            for (int shisetsuIndex = 0; shisetsuIndex < 施設入退所情報EntityList.size(); shisetsuIndex++) {
                ShisetsuNyutaishojohoEntity 施設入退所情報Entity = 施設入退所情報EntityList.get(shisetsuIndex);
                source.listShisetsuNyutaisho_1 = 施設入退所情報Entity.get施設入退所区分();
                source.listShisetsuNyutaisho_2 = 施設入退所情報Entity.get明細番号();
                source.listShisetsuNyutaisho_3 = 施設入退所情報Entity.get施設入所日().wareki().toDateString();
                source.listShisetsuNyutaisho_4 = 施設入退所情報Entity.get施設退所日().wareki().toDateString();
                source.listShisetsuNyutaisho_5 = 施設入退所情報Entity.get施設コード();
                source.listShisetsuNyutaisho_6 = 施設入退所情報Entity.get入所施設名称();
                //TODO ReportSourceに、この内容がない
//                source.listShisetsuNyutaisho_7 = 施設入退所情報Entity.get電話番号();
            }
        }
    }

    private void setKyotakuKeikaku(JukyushaDaichoReportSource source) {
        List<ItakuKeikakuTodokedejohoEntity> 居宅計画届出情報EntityList = this.帳票出力用受給者台帳.get居宅計画届出情報EntityList();
        if (居宅計画届出情報EntityList != null && !居宅計画届出情報EntityList.isEmpty()) {
            for (int kyotakuIndex = 0; kyotakuIndex < 居宅計画届出情報EntityList.size(); kyotakuIndex++) {
                ItakuKeikakuTodokedejohoEntity 居宅計画届出情報Entity = 居宅計画届出情報EntityList.get(kyotakuIndex);
                source.listKyotakuKeikaku_1 = 居宅計画届出情報Entity.get居宅計画区分();
                source.listKyotakuKeikaku_2 = 居宅計画届出情報Entity.get明細番号();
                source.listKyotakuKeikaku_3 = 居宅計画届出情報Entity.get対象年月().wareki().toDateString();
                source.listKyotakuKeikaku_4 = 居宅計画届出情報Entity.get区分();
                source.listKyotakuKeikaku_5 = 居宅計画届出情報Entity.get作成();
                source.listKyotakuKeikaku_6 = 居宅計画届出情報Entity.get計画届出日().wareki().toDateString();
                source.listKyotakuKeikaku_7 = 居宅計画届出情報Entity.get変更日().wareki().toDateString();
                source.listKyotakuKeikaku_8 = 居宅計画届出情報Entity.get適用開始日().wareki().toDateString();
                source.listKyotakuKeikaku_9 = 居宅計画届出情報Entity.get適用終了日().wareki().toDateString();
                source.listKyotakuKeikaku_10 = 居宅計画届出情報Entity.get事業所番号();
                source.listKyotakuKeikaku_11 = 居宅計画届出情報Entity.get事業所名称();
                //TODO ReportSourceに、この内容がない
//                source.listKyotakuKeikaku_12 = 居宅計画届出情報Entity.get電話番号();
            }
        }
    }

    private void setTokureiShisetsuNyutaisho(JukyushaDaichoReportSource source) {
        List<TokureiShisetuNyutaishojohoEntity> 特例施設入退所情報EntityList = this.帳票出力用受給者台帳.get特例施設入退所情報EntityList();
        if (特例施設入退所情報EntityList != null && !特例施設入退所情報EntityList.isEmpty()) {
            for (int tokureiIndex = 0; tokureiIndex < 特例施設入退所情報EntityList.size(); tokureiIndex++) {
                TokureiShisetuNyutaishojohoEntity 特例施設入退所情報Entity = 特例施設入退所情報EntityList.get(tokureiIndex);
                source.listTokureiShisetsuNyutaisho_1 = 特例施設入退所情報Entity.get特例施設入退所区分();
                source.listTokureiShisetsuNyutaisho_2 = 特例施設入退所情報Entity.get明細番号();
                source.listTokureiShisetsuNyutaisho_3 = 特例施設入退所情報Entity.get入所日().wareki().toDateString();
                source.listTokureiShisetsuNyutaisho_4 = 特例施設入退所情報Entity.get退所日().wareki().toDateString();
                source.listTokureiShisetsuNyutaisho_5 = 特例施設入退所情報Entity.get事業所番号();
                source.listTokureiShisetsuNyutaisho_6 = 特例施設入退所情報Entity.get事業所();
                //TODO ReportSourceに、この内容がない
//                source.listTokureiShisetsuNyutaisho_7=特例施設入退所情報Entity.get電話番号();
            }
        }
    }

    private void setShiharaiHohoHenko(JukyushaDaichoReportSource source) {
        List<ShiharaHohoHenkojohoEntity> 支払方法変更情報EntityList = this.帳票出力用受給者台帳.get支払方法変更情報EntityList();
        if (支払方法変更情報EntityList != null && !支払方法変更情報EntityList.isEmpty()) {
            for (int shiharaIndex = 0; shiharaIndex < 支払方法変更情報EntityList.size(); shiharaIndex++) {
                ShiharaHohoHenkojohoEntity 支払方法変更情報Entity = 支払方法変更情報EntityList.get(shiharaIndex);
                source.listShiharaiHohoHenko_1 = 支払方法変更情報Entity.get支払方法変更区分();
                source.listShiharaiHohoHenko_2 = 支払方法変更情報Entity.get明細番号();
                source.listShiharaiHohoHenko_3 = 支払方法変更情報Entity.get給付制限().get名称();
                source.listShiharaiHohoHenko_4 = 支払方法変更情報Entity.get開始日().wareki().toDateString();
                source.listShiharaiHohoHenko_5 = 支払方法変更情報Entity.get終了日().wareki().toDateString();
                source.listShiharaiHohoHenko_6 = 支払方法変更情報Entity.get終了事由().get名称();
                source.listShiharaiHohoHenko_7 = 支払方法変更情報Entity.get差止状況();
                source.listShiharaiHohoHenko_8 = 支払方法変更情報Entity.get提供年月().wareki().toDateString();
                source.listShiharaiHohoHenko_9 = 支払方法変更情報Entity.get整理番号();
                //TODO ReportSourceに、この内容がない
//                source.listShiharaiHohoHenko_10 = 支払方法変更情報Entity.get控除();
            }
        }
    }

    private void setKyufugakuGengaku(JukyushaDaichoReportSource source) {
        List<KyufugakuGengakujohoEntity> 給付額減額情報EntityList = this.帳票出力用受給者台帳.get給付額減額情報EntityList();
        if (給付額減額情報EntityList != null && !給付額減額情報EntityList.isEmpty()) {
            for (int kyufugakuIndex = 0; kyufugakuIndex < 給付額減額情報EntityList.size(); kyufugakuIndex++) {
                KyufugakuGengakujohoEntity 給付額減額情報Entity = 給付額減額情報EntityList.get(kyufugakuIndex);
                source.listKyufugakuGengaku_1 = 給付額減額情報Entity.get給付額減額区分();
                source.listKyufugakuGengaku_2 = 給付額減額情報Entity.get明細番号();
                source.listKyufugakuGengaku_3 = 給付額減額情報Entity.get給付制限().get名称();
                source.listKyufugakuGengaku_4 = 給付額減額情報Entity.get開始日().wareki().toDateString();
                source.listKyufugakuGengaku_5 = 給付額減額情報Entity.get終了日().wareki().toDateString();
                source.listKyufugakuGengaku_6 = 給付額減額情報Entity.get給付率();
                source.listKyufugakuGengaku_7 = 給付額減額情報Entity.get徴収権消滅期間();
                source.listKyufugakuGengaku_8 = 給付額減額情報Entity.get納付済期間();
                //TODO ReportSourceに、この内容がない
//                source.listKyufugakuGengaku_9 = 給付額減額情報Entity.get減額期間();
            }
        }
    }

    private void setShikaku(JukyushaDaichoReportSource source) {
        List<ShikakujohoEntity> 資格情報EntityList = this.帳票出力用受給者台帳.get資格情報EntityList();
        if (資格情報EntityList != null && !資格情報EntityList.isEmpty()) {
            for (int shikakuIndex = 0; shikakuIndex < 資格情報EntityList.size(); shikakuIndex++) {
                ShikakujohoEntity 資格情報Entity = 資格情報EntityList.get(shikakuIndex);
                source.listShikaku_1 = 資格情報Entity.get資格区分();
                source.listShikaku_2 = 資格情報Entity.get明細番号();
                source.listShikaku_3 = 資格情報Entity.get資格取得日().wareki().toDateString();
                source.listShikaku_4 = 資格情報Entity.get取得届出日().wareki().toDateString();
                source.listShikaku_5 = 資格情報Entity.get取得事由().get名称();
                source.listShikaku_6 = 資格情報Entity.get資格喪失日().wareki().toDateString();
                source.listShikaku_7 = 資格情報Entity.get喪失届出日().wareki().toDateString();
                source.listShikaku_8 = 資格情報Entity.get喪失事由().get名称();
                source.listShikaku_9 = 資格情報Entity.get変更年月日().wareki().toDateString();
                source.listShikaku_10 = 資格情報Entity.get変更届出日().wareki().toDateString();
                source.listShikaku_11 = 資格情報Entity.get変更事由().get名称();
                source.listShikaku_12 = 資格情報Entity.get適用開始日().wareki().toDateString();
                source.listShikaku_13 = 資格情報Entity.get適用届出日().wareki().toDateString();
                source.listShikaku_14 = 資格情報Entity.get適用事由().get名称();
                source.listShikaku_15 = 資格情報Entity.get解除開始日().wareki().toDateString();
                source.listShikaku_16 = 資格情報Entity.get解除届出日().wareki().toDateString();
                //TODO ReportSourceに、この内容がない
//                source.listShikaku_17 = 資格情報Entity.get解除事由().get名称();
            }
        }
    }

    private void setRoreiFukushiNenkin(JukyushaDaichoReportSource source) {
        List<RoreiFukushiNenkinjohoEntity> 老齢福祉年金情報EntityList = this.帳票出力用受給者台帳.get老齢福祉年金情報EntityList();
        if (老齢福祉年金情報EntityList != null && !老齢福祉年金情報EntityList.isEmpty()) {
            for (int roreiIndex = 0; roreiIndex < 老齢福祉年金情報EntityList.size(); roreiIndex++) {
                RoreiFukushiNenkinjohoEntity 老齢福祉年金情報Entity = 老齢福祉年金情報EntityList.get(roreiIndex);
                source.listRoreiFukushiNenkin_1 = 老齢福祉年金情報Entity.get老齢福祉年金区分();
                source.listRoreiFukushiNenkin_2 = 老齢福祉年金情報Entity.get明細番号();
                source.listRoreiFukushiNenkin_3 = 老齢福祉年金情報Entity.get老福開始日().wareki().toDateString();
                //TODO ReportSourceに、この内容がない
//                source.listRoreiFukushiNenkin_4 = 老齢福祉年金情報Entity.get老福終了日().wareki().toDateString();
            }
        }
    }

    private void setSeikatsuHogo(JukyushaDaichoReportSource source) {
        List<SeikatsuHogojohoEntity> 生活保護情報EntityList = this.帳票出力用受給者台帳.get生活保護情報EntityList();
        if (生活保護情報EntityList != null && !生活保護情報EntityList.isEmpty()) {
            for (int seikatsuIndex = 0; seikatsuIndex < 生活保護情報EntityList.size(); seikatsuIndex++) {
                SeikatsuHogojohoEntity 生活保護情報Entity = 生活保護情報EntityList.get(seikatsuIndex);
                source.listSeikatsuHogo_1 = 生活保護情報Entity.get生活保護区分();
                source.listSeikatsuHogo_2 = 生活保護情報Entity.get明細番号();
                source.listSeikatsuHogo_3 = 生活保護情報Entity.get生保開始日().wareki().toDateString();
                source.listSeikatsuHogo_4 = 生活保護情報Entity.get生保終了日().wareki().toDateString();
                //TODO ReportSourceに、この内容がない
//                source.listSeikatsuHogo_5 = 生活保護情報Entity.get生保種別();
            }
        }
    }

    private void setSentoStep2(JukyushaDaichoReportSource source) {
        List<YokaigoNinteiJohoEntity> 要介護認定情報EntityList = this.帳票出力用受給者台帳.get要介護認定情報EntityList();
        for (int yokaigoIndex = 0; yokaigoIndex < 要介護認定情報EntityList.size(); yokaigoIndex++) {
            if (要介護認定情報EntityList.get(yokaigoIndex).get先頭Entity() != null) {
                SentoEntity 先頭Entity = 要介護認定情報EntityList.get(yokaigoIndex).get先頭Entity();
                source.nigoIryoShurui = 先頭Entity.get医療種別();
                //TODO QA 上記と同じ、違うと思います
//                source.nigoHokenshaNo = 先頭Entity.get保険者番号();
//                source.nigoHokenshaName = 先頭Entity.get保険者名称();
                source.nigoBango = 先頭Entity.get記号番号();
                source.chokukinKanrihyo = new RString(先頭Entity.get直近管理票().toString());
                source.chokukinJiseki = new RString(先頭Entity.get直近実績().toString());
                source.chokukinKogaku = new RString(先頭Entity.get直近高額().toString());
                source.chokukinShokan = new RString(先頭Entity.get直近償還().toString());
                source.chokukinShotokuDankai = 先頭Entity.get直近所得段階();
                source.homonChosaSakiYubinno = 先頭Entity.get調査先郵便番号();
                source.homonChosaSakiJusho = 先頭Entity.get調査先住所();
                source.homonChosaSakiName = 先頭Entity.get調査先名称();
                source.homonChosaSakiTelNo = 先頭Entity.get調査先電話番号();
                source.biko = 先頭Entity.get備考();
            }
        }
    }

    private RString get印刷日時() {
        FlexibleDate システム日 = FlexibleDate.getNowDate();
        RTime システム日時 = RTime.now();
        RString 年月日 = システム日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 時分秒 = システム日時.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        return 年月日.concat("").concat(時分秒).concat("").concat("作成");
    }
}
