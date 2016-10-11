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

    private static final int NOCOUNT_5 = 5;
    private static final RString 全角スペース = new RString("　");
    private static final RString 作成 = new RString("作成");

    private final TyohyoShutuRyokuYoJukyushaDaichoEntity 帳票出力用受給者台帳;
    private final int index;
    private final int page;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票出力用受給者台帳 JukyushaDaichoEntity
     * @param index int
     * @param page int
     */
    public JukyushaDaichoEditor(TyohyoShutuRyokuYoJukyushaDaichoEntity 帳票出力用受給者台帳, int index, int page) {
        this.帳票出力用受給者台帳 = 帳票出力用受給者台帳;
        this.index = index;
        this.page = page;

    }

    @Override
    public JukyushaDaichoReportSource edit(JukyushaDaichoReportSource source) {
        setSentoStep1(source);
        setSentoStep2(source);
        setYokaigoNinteiLower(source);
        if (index >= (page - 1) * NOCOUNT_5 && index < page * NOCOUNT_5) {
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
        }
        return source;
    }

    private void setSentoStep1(JukyushaDaichoReportSource source) {
        source.printTimeStamp = get印刷日時();
        if (this.帳票出力用受給者台帳.get要介護認定情報EntityList() != null
                && !this.帳票出力用受給者台帳.get要介護認定情報EntityList().isEmpty()) {
            List<YokaigoNinteiJohoEntity> 要介護認定情報EntityList = this.帳票出力用受給者台帳.get要介護認定情報EntityList();
            if (要介護認定情報EntityList.size() - 1 >= index && 要介護認定情報EntityList.get(index).get先頭Entity() != null) {
                SentoEntity 先頭Entity = 要介護認定情報EntityList.get(index).get先頭Entity();
                get先頭1(source, 先頭Entity);
                get先頭2(source, 先頭Entity);
            }
        }
    }

    private void setYokaigoNinteiLower(JukyushaDaichoReportSource source) {
        List<YokaigoNinteiJohoEntity> 要介護認定情報EntityList = this.帳票出力用受給者台帳.get要介護認定情報EntityList();
        if (要介護認定情報EntityList != null && !要介護認定情報EntityList.isEmpty() && 要介護認定情報EntityList.size() - 1 >= index) {
            YokaigoNinteiJohoEntity 要介護認定情報Entity = 要介護認定情報EntityList.get(index);
            if (要介護認定情報Entity.get認定区分() != null) {
                source.ninteiKbn = 要介護認定情報Entity.get認定区分();
            }
            source.listNinteiCenter_1 = new RString(String.valueOf(index + 1)).padZeroToLeft(2);
            if (要介護認定情報Entity.get認定申請日() != null) {
                source.listNinteiUpper_1 = 要介護認定情報Entity.get認定申請日().wareki().toDateString();
            }
            if (要介護認定情報Entity.get認定日() != null) {
                source.listNinteiUpper_2 = 要介護認定情報Entity.get認定日().wareki().toDateString();
            }
            if (要介護認定情報Entity.get申請事由() != null) {
                source.listNinteiCenter_2 = 要介護認定情報Entity.get申請事由();
            }
            if (要介護認定情報Entity.get異動事由() != null) {
                source.listNinteiLower_1 = 要介護認定情報Entity.get異動事由();
            }
            if (要介護認定情報Entity.get要介護度() != null) {
                source.listNinteiUpper_3 = 要介護認定情報Entity.get要介護度();
            }
            if (要介護認定情報Entity.get認定開始日() != null) {
                source.listNinteiUpper_4 = 要介護認定情報Entity.get認定開始日().wareki().toDateString();
            }
            if (要介護認定情報Entity.get認定終了日() != null) {
                source.listNinteiUpper_5 = 要介護認定情報Entity.get認定終了日().wareki().toDateString();
            }
            if (要介護認定情報Entity.get訪問限度額() != null) {
                source.listNinteiCenter_3 = new RString(要介護認定情報Entity.get訪問限度額().toString());
            }
            if (要介護認定情報Entity.get訪問開始日() != null) {
                source.listNinteiCenter_4 = 要介護認定情報Entity.get訪問開始日().wareki().toDateString();
            }
            if (要介護認定情報Entity.get訪問終了日() != null) {
                source.listNinteiCenter_5 = 要介護認定情報Entity.get訪問終了日().wareki().toDateString();
            }
            if (要介護認定情報Entity.get短期限度額() != null) {
                source.listNinteiLower_2 = new RString(要介護認定情報Entity.get短期限度額().toString());
            }
            if (要介護認定情報Entity.get短期開始日() != null) {
                source.listNinteiLower_3 = 要介護認定情報Entity.get短期開始日().wareki().toDateString();
            }
            if (要介護認定情報Entity.get短期終了日() != null) {
                source.listNinteiLower_4 = 要介護認定情報Entity.get短期終了日().wareki().toDateString();
            }
            get要介護認定情報1(source, 要介護認定情報Entity);
            get要介護認定情報2(source, 要介護認定情報Entity);
        }

    }

    private void setFutanGendogakuNintei(JukyushaDaichoReportSource source) {
        List<FutanGendogakuNinteiJohoEntity> 負担限度額認定情報EntityList = this.帳票出力用受給者台帳.get負担限度額認定情報EntityList();
        if (負担限度額認定情報EntityList != null
                && !負担限度額認定情報EntityList.isEmpty()
                && 負担限度額認定情報EntityList.size() - 1 >= index) {
            FutanGendogakuNinteiJohoEntity 負担限度額認定情報Entity = 負担限度額認定情報EntityList.get(index - 2 * (page - 1));
            if (負担限度額認定情報Entity.get負担限度額認定区分() != null) {
                source.futanGendogakuNinteiKbn = 負担限度額認定情報Entity.get負担限度額認定区分();
            }
            source.listFutanGendogakuNintei_1 = new RString(String.valueOf(index - 2 * (page - 1) + 1)).padZeroToLeft(2);
            if (負担限度額認定情報Entity.get申請年月日() != null) {
                source.listFutanGendogakuNintei_2 = 負担限度額認定情報Entity.get申請年月日().wareki().toDateString();
            }
            if (負担限度額認定情報Entity.get申請理由() != null) {
                source.listFutanGendogakuNintei_3 = 負担限度額認定情報Entity.get申請理由();
            }
            if (負担限度額認定情報Entity.get決定年月日() != null) {
                source.listFutanGendogakuNintei_4 = 負担限度額認定情報Entity.get決定年月日().wareki().toDateString();
            }
            if (負担限度額認定情報Entity.get適用年月日() != null) {
                source.listFutanGendogakuNintei_5 = 負担限度額認定情報Entity.get適用年月日().wareki().toDateString();
            }
            if (負担限度額認定情報Entity.get有効期限() != null) {
                source.listFutanGendogakuNintei_6 = 負担限度額認定情報Entity.get有効期限().wareki().toDateString();
            }
            if (負担限度額認定情報Entity.get負担段階() != null) {
                source.listFutanGendogakuNintei_7 = 負担限度額認定情報Entity.get負担段階();
            }
            if (負担限度額認定情報Entity.get旧措置() != null) {
                source.listFutanGendogakuNintei_8 = 負担限度額認定情報Entity.get旧措置();
            }
            if (負担限度額認定情報Entity.get居室種別() != null) {
                source.listFutanGendogakuNintei_9 = 負担限度額認定情報Entity.get居室種別();
            }
            if (負担限度額認定情報Entity.get食費() != null) {
                source.listFutanGendogakuNintei_10 = new RString(負担限度額認定情報Entity.get食費().toString());
            }
            get負担限度額認定情報(source, 負担限度額認定情報Entity);
        }
    }

    private void setShaFukuKeigen(JukyushaDaichoReportSource source) {
        List<ShafuHojinKeigenJohoEntity> 社福法人軽減情報EntityList = this.帳票出力用受給者台帳.get社福法人軽減情報EntityList();
        if (社福法人軽減情報EntityList != null && !社福法人軽減情報EntityList.isEmpty() && 社福法人軽減情報EntityList.size() - 1 >= index) {
            ShafuHojinKeigenJohoEntity 社福法人軽減情報Entity = 社福法人軽減情報EntityList.get(index - 2 * (page - 1));
            if (社福法人軽減情報Entity.get社福軽減区分() != null) {
                source.shaFukuKeigenKbn = 社福法人軽減情報Entity.get社福軽減区分();
            }
            source.listShaFukuKeigen_1 = new RString(String.valueOf(index - 2 * (page - 1) + 1)).padZeroToLeft(2);
            if (社福法人軽減情報Entity.get減免申請日() != null) {
                source.listShaFukuKeigen_2 = 社福法人軽減情報Entity.get減免申請日().wareki().toDateString();
            }
            if (社福法人軽減情報Entity.get減免決定日() != null) {
                source.listShaFukuKeigen_3 = 社福法人軽減情報Entity.get減免決定日().wareki().toDateString();
            }
            if (社福法人軽減情報Entity.get減免開始日() != null) {
                source.listShaFukuKeigen_4 = 社福法人軽減情報Entity.get減免開始日().wareki().toDateString();
            }
            if (社福法人軽減情報Entity.get減免終了日() != null) {
                source.listShaFukuKeigen_5 = 社福法人軽減情報Entity.get減免終了日().wareki().toDateString();
            }
            if (社福法人軽減情報Entity.get確認番号() != null) {
                source.listShaFukuKeigen_6 = 社福法人軽減情報Entity.get確認番号();
            }
            if (社福法人軽減情報Entity.get軽減率() != null) {
                source.listShaFukuKeigen_7 = 社福法人軽減情報Entity.get軽減率();
            }
            if (社福法人軽減情報Entity.get居宅限定() != null) {
                source.listShaFukuKeigen_8 = 社福法人軽減情報Entity.get居宅限定();
            }
            if (社福法人軽減情報Entity.get居_食限定() != null) {
                source.listShaFukuKeigen_9 = 社福法人軽減情報Entity.get居_食限定();
            }
            if (社福法人軽減情報Entity.get旧措限定() != null) {
                source.listShaFukuKeigen_10 = 社福法人軽減情報Entity.get旧措限定();
            }
        }
    }

    private void setRiyoshaFutanGenmen(JukyushaDaichoReportSource source) {
        List<RiyoshaFutanGenmenJohoEntity> 利用者負担減免情報EntityList = this.帳票出力用受給者台帳.get利用者負担減免情報EntityList();
        if (利用者負担減免情報EntityList != null && !利用者負担減免情報EntityList.isEmpty() && 利用者負担減免情報EntityList.size() - 1 >= index) {
            RiyoshaFutanGenmenJohoEntity 利用者負担減免情報Entity = 利用者負担減免情報EntityList.get(index - 2 * (page - 1));
            if (利用者負担減免情報Entity.get利用者負担減免区分() != null) {
                source.riyoshaFutanGenmenKbn = 利用者負担減免情報Entity.get利用者負担減免区分();
            }
            source.listRiyoshaFutanGenmen_1 = new RString(String.valueOf(index - 2 * (page - 1) + 1)).padZeroToLeft(2);
            if (利用者負担減免情報Entity.get減免申請日() != null) {
                source.listRiyoshaFutanGenmen_2 = 利用者負担減免情報Entity.get減免申請日().wareki().toDateString();
            }
            if (利用者負担減免情報Entity.get減免決定日() != null) {
                source.listRiyoshaFutanGenmen_3 = 利用者負担減免情報Entity.get減免決定日().wareki().toDateString();
            }
            if (利用者負担減免情報Entity.get減免開始日() != null) {
                source.listRiyoshaFutanGenmen_4 = 利用者負担減免情報Entity.get減免開始日().wareki().toDateString();
            }
            if (利用者負担減免情報Entity.get減免終了日() != null) {
                source.listRiyoshaFutanGenmen_5 = 利用者負担減免情報Entity.get減免終了日().wareki().toDateString();
            }
            if (利用者負担減免情報Entity.get給付率() != null) {
                source.listRiyoshaFutanGenmen_6 = 利用者負担減免情報Entity.get給付率();
            }
        }
    }

    private void setHoumonKaigoRiyoshaFutanGengaku(JukyushaDaichoReportSource source) {
        List<HomonKaigoGenmenJohoEntity> 訪問介護等減額情報EntityList = this.帳票出力用受給者台帳.get訪問介護等減額情報EntityList();
        if (訪問介護等減額情報EntityList != null && !訪問介護等減額情報EntityList.isEmpty() && 訪問介護等減額情報EntityList.size() - 1 >= index) {
            HomonKaigoGenmenJohoEntity 訪問介護等減額情報Entity = 訪問介護等減額情報EntityList.get(index - 2 * (page - 1));
            if (訪問介護等減額情報Entity.get訪問介護利用者負担減額区分() != null) {
                source.honmonKaigoRiyoshaFutanGengakuKbn = 訪問介護等減額情報Entity.get訪問介護利用者負担減額区分();
            }
            source.listHonmonKaigoRiyoshaFutanGengaku_1 = new RString(String.valueOf(index - 2 * (page - 1) + 1)).padZeroToLeft(2);
            if (訪問介護等減額情報Entity.get減免申請日() != null) {
                source.listHonmonKaigoRiyoshaFutanGengaku_2 = 訪問介護等減額情報Entity.get減免申請日().wareki().toDateString();
            }
            if (訪問介護等減額情報Entity.get減免決定日() != null) {
                source.listHonmonKaigoRiyoshaFutanGengaku_3 = 訪問介護等減額情報Entity.get減免決定日().wareki().toDateString();
            }
            if (訪問介護等減額情報Entity.get減免開始日() != null) {
                source.listHonmonKaigoRiyoshaFutanGengaku_4 = 訪問介護等減額情報Entity.get減免開始日().wareki().toDateString();
            }
            if (訪問介護等減額情報Entity.get減免終了日() != null) {
                source.listHonmonKaigoRiyoshaFutanGengaku_5 = 訪問介護等減額情報Entity.get減免終了日().wareki().toDateString();
            }
            if (訪問介護等減額情報Entity.get給付率() != null) {
                source.listHonmonKaigoRiyoshaFutanGengaku_6 = 訪問介護等減額情報Entity.get給付率();
            }
            if (訪問介護等減額情報Entity.get法別() != null) {
                source.listHonmonKaigoRiyoshaFutanGengaku_7 = 訪問介護等減額情報Entity.get法別().get名称();
            }
            if (訪問介護等減額情報Entity.get受給者番号() != null) {
                source.listHonmonKaigoRiyoshaFutanGengaku_8 = 訪問介護等減額情報Entity.get受給者番号();
            }
        }
    }

    private void setHyojunFutanGengaku(JukyushaDaichoReportSource source) {
        List<HyojunFutanGengakuJohoEntity> 標準負担減額情報EntityList = this.帳票出力用受給者台帳.get標準負担減額情報EntityList();
        if (標準負担減額情報EntityList != null && !標準負担減額情報EntityList.isEmpty() && 標準負担減額情報EntityList.size() - 1 >= index) {
            HyojunFutanGengakuJohoEntity 標準負担減額情報Entity = 標準負担減額情報EntityList.get(index - 2 * (page - 1));
            if (標準負担減額情報Entity.get標準負担減額区分() != null) {
                source.hyojunFutanGengakuKbn = 標準負担減額情報Entity.get標準負担減額区分();
            }
            source.listHyojunFutanGengaku_1 = new RString(String.valueOf(index - 2 * (page - 1) + 1)).padZeroToLeft(2);
            if (標準負担減額情報Entity.get減免申請日() != null) {
                source.listHyojunFutanGengaku_2 = 標準負担減額情報Entity.get減免申請日().wareki().toDateString();
            }
            if (標準負担減額情報Entity.get減免決定日() != null) {
                source.listHyojunFutanGengaku_3 = 標準負担減額情報Entity.get減免決定日().wareki().toDateString();
            }
            if (標準負担減額情報Entity.get減免開始日() != null) {
                source.listHyojunFutanGengaku_4 = 標準負担減額情報Entity.get減免開始日().wareki().toDateString();
            }
            if (標準負担減額情報Entity.get減免終了日() != null) {
                source.listHyojunFutanGengaku_5 = 標準負担減額情報Entity.get減免終了日().wareki().toDateString();
            }
            if (標準負担減額情報Entity.get負担額() != null) {
                source.listHyojunFutanGengaku_6 = 標準負担減額情報Entity.get負担額();
            }
        }
    }

    private void setTokubetsuChiikiKasanGenmen(JukyushaDaichoReportSource source) {
        List<TokubetsuChiikiKasanGenmenJohoEntity> 特別地域加算減免情報EntityList = this.帳票出力用受給者台帳.get特別地域加算減免情報EntityList();
        if (特別地域加算減免情報EntityList != null && !特別地域加算減免情報EntityList.isEmpty() && 特別地域加算減免情報EntityList.size() - 1 >= index) {
            TokubetsuChiikiKasanGenmenJohoEntity 特別地域加算減免情報Entity = 特別地域加算減免情報EntityList.get(index - 2 * (page - 1));
            if (特別地域加算減免情報Entity.get特別地域加算減免区分() != null) {
                source.tokubetsuChiikiKasanGenmenKbn = 特別地域加算減免情報Entity.get特別地域加算減免区分();
            }
            source.listTokubetsuChiikiKasanGenmen_1 = new RString(String.valueOf(index - 2 * (page - 1) + 1)).padZeroToLeft(2);
            if (特別地域加算減免情報Entity.get申請年月日() != null) {
                source.listTokubetsuChiikiKasanGenmen_2 = 特別地域加算減免情報Entity.get申請年月日().wareki().toDateString();
            }
            if (特別地域加算減免情報Entity.get決定年月日() != null) {
                source.listTokubetsuChiikiKasanGenmen_3 = 特別地域加算減免情報Entity.get決定年月日().wareki().toDateString();
            }
            if (特別地域加算減免情報Entity.get適用年月日() != null) {
                source.listTokubetsuChiikiKasanGenmen_4 = 特別地域加算減免情報Entity.get適用年月日().wareki().toDateString();
            }
            if (特別地域加算減免情報Entity.get有効期限() != null) {
                source.listTokubetsuChiikiKasanGenmen_5 = 特別地域加算減免情報Entity.get有効期限().wareki().toDateString();
            }
            if (特別地域加算減免情報Entity.get減額率() != null) {
                source.listTokubetsuChiikiKasanGenmen_6 = 特別地域加算減免情報Entity.get減額率();
            }
            if (特別地域加算減免情報Entity.get確認番号() != null) {
                source.listTokubetsuChiikiKasanGenmen_7 = 特別地域加算減免情報Entity.get確認番号();
            }
        }
    }

    private void setShisetsuNyutaisho(JukyushaDaichoReportSource source) {
        List<ShisetsuNyutaishojohoEntity> 施設入退所情報EntityList = this.帳票出力用受給者台帳.get施設入退所情報EntityList();
        if (施設入退所情報EntityList != null && !施設入退所情報EntityList.isEmpty() && 施設入退所情報EntityList.size() - 1 >= index) {
            ShisetsuNyutaishojohoEntity 施設入退所情報Entity = 施設入退所情報EntityList.get(index - 2 * (page - 1));
            if (施設入退所情報Entity.get施設入退所区分() != null) {
                source.shisetsuNyutaishoKbn = 施設入退所情報Entity.get施設入退所区分();
            }
            source.listShisetsuNyutaisho_1 = new RString(String.valueOf(index - 2 * (page - 1) + 1)).padZeroToLeft(2);
            if (施設入退所情報Entity.get施設入所日() != null) {
                source.listShisetsuNyutaisho_2 = 施設入退所情報Entity.get施設入所日().wareki().toDateString();
            }
            if (施設入退所情報Entity.get施設退所日() != null) {
                source.listShisetsuNyutaisho_3 = 施設入退所情報Entity.get施設退所日().wareki().toDateString();
            }
            if (施設入退所情報Entity.get施設コード() != null) {
                source.listShisetsuNyutaisho_4 = 施設入退所情報Entity.get施設コード();
            }
            if (施設入退所情報Entity.get入所施設名称() != null) {
                source.listShisetsuNyutaisho_5 = 施設入退所情報Entity.get入所施設名称();
            }
            if (施設入退所情報Entity.get電話番号() != null) {
                source.listShisetsuNyutaisho_6 = 施設入退所情報Entity.get電話番号();
            }
        }
    }

    private void setKyotakuKeikaku(JukyushaDaichoReportSource source) {
        List<ItakuKeikakuTodokedejohoEntity> 居宅計画届出情報EntityList = this.帳票出力用受給者台帳.get居宅計画届出情報EntityList();
        if (居宅計画届出情報EntityList != null && !居宅計画届出情報EntityList.isEmpty() && 居宅計画届出情報EntityList.size() - 1 >= index) {
            ItakuKeikakuTodokedejohoEntity 居宅計画届出情報Entity = 居宅計画届出情報EntityList.get(index - 2 * (page - 1));
            if (居宅計画届出情報Entity.get居宅計画区分() != null) {
                source.kyotakuKeikakuKbn = 居宅計画届出情報Entity.get居宅計画区分();
            }
            source.listKyotakuKeikaku_1 = new RString(String.valueOf(index - 2 * (page - 1) + 1)).padZeroToLeft(2);
            if (居宅計画届出情報Entity.get対象年月() != null) {
                source.listKyotakuKeikaku_2 = 居宅計画届出情報Entity.get対象年月().wareki().toDateString();
            }
            if (居宅計画届出情報Entity.get区分() != null) {
                source.listKyotakuKeikaku_3 = 居宅計画届出情報Entity.get区分();
            }
            if (居宅計画届出情報Entity.get作成() != null) {
                source.listKyotakuKeikaku_4 = 居宅計画届出情報Entity.get作成();
            }
            if (居宅計画届出情報Entity.get計画届出日() != null) {
                source.listKyotakuKeikaku_5 = 居宅計画届出情報Entity.get計画届出日().wareki().toDateString();
            }
            if (居宅計画届出情報Entity.get変更日() != null) {
                source.listKyotakuKeikaku_6 = 居宅計画届出情報Entity.get変更日().wareki().toDateString();
            }
            if (居宅計画届出情報Entity.get適用開始日() != null) {
                source.listKyotakuKeikaku_7 = 居宅計画届出情報Entity.get適用開始日().wareki().toDateString();
            }
            if (居宅計画届出情報Entity.get適用終了日() != null) {
                source.listKyotakuKeikaku_8 = 居宅計画届出情報Entity.get適用終了日().wareki().toDateString();
            }
            if (居宅計画届出情報Entity.get事業所番号() != null) {
                source.listKyotakuKeikaku_9 = 居宅計画届出情報Entity.get事業所番号();
            }
            if (居宅計画届出情報Entity.get事業所名称() != null) {
                source.listKyotakuKeikaku_10 = 居宅計画届出情報Entity.get事業所名称();
            }
            if (居宅計画届出情報Entity.get電話番号() != null) {
                source.listKyotakuKeikaku_11 = 居宅計画届出情報Entity.get電話番号();
            }
        }
    }

    private void setTokureiShisetsuNyutaisho(JukyushaDaichoReportSource source) {
        List<TokureiShisetuNyutaishojohoEntity> 特例施設入退所情報EntityList = this.帳票出力用受給者台帳.get特例施設入退所情報EntityList();
        if (特例施設入退所情報EntityList != null && !特例施設入退所情報EntityList.isEmpty() && 特例施設入退所情報EntityList.size() - 1 >= index) {
            TokureiShisetuNyutaishojohoEntity 特例施設入退所情報Entity = 特例施設入退所情報EntityList.get(index - 2 * (page - 1));
            if (特例施設入退所情報Entity.get特例施設入退所区分() != null) {
                source.tokureiShisetsuNyutaishoKbn = 特例施設入退所情報Entity.get特例施設入退所区分();
            }
            source.listTokureiShisetsuNyutaisho_1 = new RString(String.valueOf(index - 2 * (page - 1) + 1)).padZeroToLeft(2);
            if (特例施設入退所情報Entity.get入所日() != null) {
                source.listTokureiShisetsuNyutaisho_2 = 特例施設入退所情報Entity.get入所日().wareki().toDateString();
            }
            if (特例施設入退所情報Entity.get退所日() != null) {
                source.listTokureiShisetsuNyutaisho_3 = 特例施設入退所情報Entity.get退所日().wareki().toDateString();
            }
            if (特例施設入退所情報Entity.get事業所番号() != null) {
                source.listTokureiShisetsuNyutaisho_4 = 特例施設入退所情報Entity.get事業所番号();
            }
            if (特例施設入退所情報Entity.get事業所() != null) {
                source.listTokureiShisetsuNyutaisho_5 = 特例施設入退所情報Entity.get事業所();
            }
            if (特例施設入退所情報Entity.get電話番号() != null) {
                source.listTokureiShisetsuNyutaisho_6 = 特例施設入退所情報Entity.get電話番号();
            }
        }
    }

    private void setShiharaiHohoHenko(JukyushaDaichoReportSource source) {
        List<ShiharaHohoHenkojohoEntity> 支払方法変更情報EntityList = this.帳票出力用受給者台帳.get支払方法変更情報EntityList();
        if (支払方法変更情報EntityList != null && !支払方法変更情報EntityList.isEmpty() && 支払方法変更情報EntityList.size() - 1 >= index) {
            ShiharaHohoHenkojohoEntity 支払方法変更情報Entity = 支払方法変更情報EntityList.get(index - 2 * (page - 1));
            if (支払方法変更情報Entity.get支払方法変更区分() != null) {
                source.shiharaiHohoHenkoKbn = 支払方法変更情報Entity.get支払方法変更区分();
            }
            source.listShiharaiHohoHenko_1 = new RString(String.valueOf(index - 2 * (page - 1) + 1)).padZeroToLeft(2);
            if (支払方法変更情報Entity.get給付制限() != null) {
                source.listShiharaiHohoHenko_2 = 支払方法変更情報Entity.get給付制限().get名称();
            }
            if (支払方法変更情報Entity.get開始日() != null) {
                source.listShiharaiHohoHenko_3 = 支払方法変更情報Entity.get開始日().wareki().toDateString();
            }
            if (支払方法変更情報Entity.get終了日() != null) {
                source.listShiharaiHohoHenko_4 = 支払方法変更情報Entity.get終了日().wareki().toDateString();
            }
            if (支払方法変更情報Entity.get終了事由() != null) {
                source.listShiharaiHohoHenko_5 = 支払方法変更情報Entity.get終了事由().get名称();
            }
            if (支払方法変更情報Entity.get差止状況() != null) {
                source.listShiharaiHohoHenko_6 = 支払方法変更情報Entity.get差止状況();
            }
            if (支払方法変更情報Entity.get提供年月() != null) {
                source.listShiharaiHohoHenko_7 = 支払方法変更情報Entity.get提供年月().wareki().toDateString();
            }
            if (支払方法変更情報Entity.get整理番号() != null) {
                source.listShiharaiHohoHenko_8 = 支払方法変更情報Entity.get整理番号();
            }
            if (支払方法変更情報Entity.get控除() != null) {
                source.listShiharaiHohoHenko_9 = 支払方法変更情報Entity.get控除();
            }
        }
    }

    private void setKyufugakuGengaku(JukyushaDaichoReportSource source) {
        List<KyufugakuGengakujohoEntity> 給付額減額情報EntityList = this.帳票出力用受給者台帳.get給付額減額情報EntityList();
        if (給付額減額情報EntityList != null && !給付額減額情報EntityList.isEmpty() && 給付額減額情報EntityList.size() - 1 >= index) {
            KyufugakuGengakujohoEntity 給付額減額情報Entity = 給付額減額情報EntityList.get(index - 2 * (page - 1));
            if (給付額減額情報Entity.get給付額減額区分() != null) {
                source.kyufugakuGengakuKbn = 給付額減額情報Entity.get給付額減額区分();
            }
            source.listKyufugakuGengaku_1 = new RString(String.valueOf(index - 2 * (page - 1) + 1)).padZeroToLeft(2);
            if (給付額減額情報Entity.get給付制限() != null) {
                source.listKyufugakuGengaku_2 = 給付額減額情報Entity.get給付制限().get名称();
            }
            if (給付額減額情報Entity.get開始日() != null) {
                source.listKyufugakuGengaku_3 = 給付額減額情報Entity.get開始日().wareki().toDateString();
            }
            if (給付額減額情報Entity.get終了日() != null) {
                source.listKyufugakuGengaku_4 = 給付額減額情報Entity.get終了日().wareki().toDateString();
            }
            if (給付額減額情報Entity.get給付率() != null) {
                source.listKyufugakuGengaku_5 = 給付額減額情報Entity.get給付率();
            }
            if (給付額減額情報Entity.get徴収権消滅期間() != null) {
                source.listKyufugakuGengaku_6 = 給付額減額情報Entity.get徴収権消滅期間();
            }
            if (給付額減額情報Entity.get納付済期間() != null) {
                source.listKyufugakuGengaku_7 = 給付額減額情報Entity.get納付済期間();
            }
            if (給付額減額情報Entity.get減額期間() != null) {
                source.listKyufugakuGengaku_8 = 給付額減額情報Entity.get減額期間();
            }
        }
    }

    private void setShikaku(JukyushaDaichoReportSource source) {
        List<ShikakujohoEntity> 資格情報EntityList = this.帳票出力用受給者台帳.get資格情報EntityList();
        if (資格情報EntityList != null && !資格情報EntityList.isEmpty() && 資格情報EntityList.size() - 1 >= index) {
            ShikakujohoEntity 資格情報Entity = 資格情報EntityList.get(index - 2 * (page - 1));
            if (資格情報Entity.get資格区分() != null) {
                source.shikakuKbn = 資格情報Entity.get資格区分();
            }
            source.listShikaku_1 = new RString(String.valueOf(index - 2 * (page - 1) + 1)).padZeroToLeft(2);
            if (資格情報Entity.get資格取得日() != null) {
                source.listShikaku_2 = 資格情報Entity.get資格取得日().wareki().toDateString();
            }
            if (資格情報Entity.get取得届出日() != null) {
                source.listShikaku_3 = 資格情報Entity.get取得届出日().wareki().toDateString();
            }
            if (資格情報Entity.get取得事由() != null) {
                source.listShikaku_4 = 資格情報Entity.get取得事由().get名称();
            }
            if (資格情報Entity.get資格喪失日() != null) {
                source.listShikaku_5 = 資格情報Entity.get資格喪失日().wareki().toDateString();
            }
            if (資格情報Entity.get喪失届出日() != null) {
                source.listShikaku_6 = 資格情報Entity.get喪失届出日().wareki().toDateString();
            }
            if (資格情報Entity.get喪失事由() != null) {
                source.listShikaku_7 = 資格情報Entity.get喪失事由().get名称();
            }
            if (資格情報Entity.get変更年月日() != null) {
                source.listShikaku_8 = 資格情報Entity.get変更年月日().wareki().toDateString();
            }
            if (資格情報Entity.get変更届出日() != null) {
                source.listShikaku_9 = 資格情報Entity.get変更届出日().wareki().toDateString();
            }
            if (資格情報Entity.get変更事由() != null) {
                source.listShikaku_10 = 資格情報Entity.get変更事由().get名称();
            }
            get資格情報(source, 資格情報Entity);
        }
    }

    private void setRoreiFukushiNenkin(JukyushaDaichoReportSource source) {
        List<RoreiFukushiNenkinjohoEntity> 老齢福祉年金情報EntityList = this.帳票出力用受給者台帳.get老齢福祉年金情報EntityList();
        if (老齢福祉年金情報EntityList != null && !老齢福祉年金情報EntityList.isEmpty() && 老齢福祉年金情報EntityList.size() - 1 >= index) {
            RoreiFukushiNenkinjohoEntity 老齢福祉年金情報Entity = 老齢福祉年金情報EntityList.get(index - 2 * (page - 1));
            if (老齢福祉年金情報Entity.get老齢福祉年金区分() != null) {
                source.roreiFukushiNenkinKbn = 老齢福祉年金情報Entity.get老齢福祉年金区分();
            }
            source.listRoreiFukushiNenkin_1 = new RString(String.valueOf(index - 2 * (page - 1) + 1)).padZeroToLeft(2);
            if (老齢福祉年金情報Entity.get老福開始日() != null) {
                source.listRoreiFukushiNenkin_2 = 老齢福祉年金情報Entity.get老福開始日().wareki().toDateString();
            }
            if (老齢福祉年金情報Entity.get老福終了日() != null) {
                source.listRoreiFukushiNenkin_3 = 老齢福祉年金情報Entity.get老福終了日().wareki().toDateString();
            }
        }
    }

    private void setSeikatsuHogo(JukyushaDaichoReportSource source) {
        List<SeikatsuHogojohoEntity> 生活保護情報EntityList = this.帳票出力用受給者台帳.get生活保護情報EntityList();
        if (生活保護情報EntityList != null && !生活保護情報EntityList.isEmpty() && 生活保護情報EntityList.size() - 1 >= index) {
            SeikatsuHogojohoEntity 生活保護情報Entity = 生活保護情報EntityList.get(index - 2 * (page - 1));
            if (生活保護情報Entity.get生活保護区分() != null) {
                source.seikatsuHogoKbn = 生活保護情報Entity.get生活保護区分();
            }
            source.listSeikatsuHogo_1 = new RString(String.valueOf(index - 2 * (page - 1) + 1)).padZeroToLeft(2);
            if (生活保護情報Entity.get生保開始日() != null) {
                source.listSeikatsuHogo_2 = 生活保護情報Entity.get生保開始日().wareki().toDateString();
            }
            if (生活保護情報Entity.get生保終了日() != null) {
                source.listSeikatsuHogo_3 = 生活保護情報Entity.get生保終了日().wareki().toDateString();
            }
            if (生活保護情報Entity.get生保種別() != null) {
                source.listSeikatsuHogo_4 = 生活保護情報Entity.get生保種別();
            }
        }
    }

    private void setSentoStep2(JukyushaDaichoReportSource source) {
        if (this.帳票出力用受給者台帳.get要介護認定情報EntityList() != null
                && !this.帳票出力用受給者台帳.get要介護認定情報EntityList().isEmpty()) {
            List<YokaigoNinteiJohoEntity> 要介護認定情報EntityList = this.帳票出力用受給者台帳.get要介護認定情報EntityList();
            if (要介護認定情報EntityList.size() - 1 >= index && 要介護認定情報EntityList.get(index).get先頭Entity() != null) {
                SentoEntity 先頭Entity = 要介護認定情報EntityList.get(index).get先頭Entity();
                get先頭3(source, 先頭Entity);

            }
        }
    }

    private RString get印刷日時() {
        FlexibleDate システム日 = FlexibleDate.getNowDate();
        RTime システム日時 = RTime.now();
        RString 年月日 = システム日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 時分秒 = システム日時.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        return 年月日.concat(全角スペース).concat(時分秒).concat(全角スペース).concat(作成);
    }

    private JukyushaDaichoReportSource get先頭1(JukyushaDaichoReportSource source, SentoEntity 先頭Entity) {
        if (先頭Entity.get保険者番号() != null) {
            source.hokenshaNo = 先頭Entity.get保険者番号();
        }
        if (先頭Entity.get保険者名称() != null) {
            source.hokenshaName = 先頭Entity.get保険者名称();
        }
        if (先頭Entity.get証記載保険者コード() != null) {
            source.shoHokenshaNo = 先頭Entity.get証記載保険者コード();
        }
        if (先頭Entity.get証記載保険者名() != null) {
            source.shoHokenshaName = 先頭Entity.get証記載保険者名();
        }
        if (先頭Entity.get被保険者に対するページ() != null) {
            source.hihokenshaPage = 先頭Entity.get被保険者に対するページ();
        }
        if (先頭Entity.get総ページ() != null) {
            source.totalPage = 先頭Entity.get総ページ();
        }
        if (先頭Entity.get被保険者番号() != null) {
            source.hihokenshaNo = 先頭Entity.get被保険者番号();
        }
        if (先頭Entity.get被保険者名() != null) {
            source.hiHokenshaName = 先頭Entity.get被保険者名();
        }
        if (先頭Entity.get被保険者名カナ() != null) {
            source.hihokenshaNameKana = 先頭Entity.get被保険者名カナ();
        }
        if (先頭Entity.get性別() != null) {
            source.seibetsu = 先頭Entity.get性別();
        }
        if (先頭Entity.get生年月日() != null) {
            source.birthYMD = 先頭Entity.get生年月日().wareki().toDateString();
        }
        if (先頭Entity.get住所コード() != null) {
            source.hihokenshaJushoCode = 先頭Entity.get住所コード();
        }
        if (先頭Entity.get住所() != null) {
            source.hihokenshaJusho = 先頭Entity.get住所();
        }
        if (先頭Entity.get世帯コード() != null) {
            source.setaiCode = 先頭Entity.get世帯コード();
        }
        if (先頭Entity.get住所コード() != null) {
            source.shikibetsuCode = 先頭Entity.get住所コード();
        }

        return source;
    }

    private JukyushaDaichoReportSource get先頭2(JukyushaDaichoReportSource source, SentoEntity 先頭Entity) {
        if (先頭Entity.get現状態() != null) {
            source.genJotai = 先頭Entity.get現状態();
        }
        if (先頭Entity.get行政区コード() != null) {
            source.gyoseikuCode = 先頭Entity.get行政区コード();
        }
        if (先頭Entity.get行政区名称() != null) {
            source.gyoseikuName = 先頭Entity.get行政区名称();
        }
        if (先頭Entity.get連絡先区分1() != null) {
            source.telTitle1 = 先頭Entity.get連絡先区分1();
        }
        if (先頭Entity.get連絡先1() != null) {
            source.telNo1 = 先頭Entity.get連絡先1();
        }
        if (先頭Entity.get連絡先区分2() != null) {
            source.telTitle2 = 先頭Entity.get連絡先区分2();
        }
        if (先頭Entity.get連絡先2() != null) {
            source.telNo2 = 先頭Entity.get連絡先2();
        }
        if (先頭Entity.get老健市町村コード() != null) {
            source.rokenCityCode = 先頭Entity.get老健市町村コード();
        }
        if (先頭Entity.get老健市町村名称() != null) {
            source.rokenCityName = 先頭Entity.get老健市町村名称();
        }
        if (先頭Entity.get老健受給者番号() != null) {
            source.rokenJukyuCode = 先頭Entity.get老健受給者番号();
        }
        if (先頭Entity.get地区タイトル1() != null) {
            source.sonotaTitle1 = 先頭Entity.get地区タイトル1();
        }
        if (先頭Entity.get地区タイトル2() != null) {
            source.sonotaTitle2 = 先頭Entity.get地区タイトル2();
        }
        if (先頭Entity.get地区タイトル3() != null) {
            source.sonotaTitle3 = 先頭Entity.get地区タイトル3();
        }
        if (先頭Entity.get地区コード1() != null) {
            source.chikuCode1 = 先頭Entity.get地区コード1();
        }
        if (先頭Entity.get地区コード2() != null) {
            source.chikuCode2 = 先頭Entity.get地区コード2();
        }
        if (先頭Entity.get地区コード3() != null) {
            source.chikuCode3 = 先頭Entity.get地区コード3();
        }
        return source;
    }

    private JukyushaDaichoReportSource get先頭3(JukyushaDaichoReportSource source, SentoEntity 先頭Entity) {
        if (先頭Entity.get医療種別() != null) {
            source.nigoIryoShurui = 先頭Entity.get医療種別();
        }
        if (先頭Entity.get医療保険者番号() != null) {
            source.nigoHokenshaNo = 先頭Entity.get医療保険者番号();
        }
        if (先頭Entity.get医療保険者名称() != null) {
            source.nigoHokenshaName = 先頭Entity.get医療保険者名称();
        }
        if (先頭Entity.get記号番号() != null) {
            source.nigoBango = 先頭Entity.get記号番号();
        }
        if (先頭Entity.get直近管理票() != null) {
            source.chokukinKanrihyo = new RString(先頭Entity.get直近管理票().toString());
        }
        if (先頭Entity.get直近実績() != null) {
            source.chokukinJiseki = new RString(先頭Entity.get直近実績().toString());
        }
        if (先頭Entity.get直近高額() != null) {
            source.chokukinKogaku = new RString(先頭Entity.get直近高額().toString());
        }
        if (先頭Entity.get直近償還() != null) {
            source.chokukinShokan = new RString(先頭Entity.get直近償還().toString());
        }
        if (先頭Entity.get直近所得段階() != null) {
            source.chokukinShotokuDankai = 先頭Entity.get直近所得段階();
        }
        if (先頭Entity.get調査先郵便番号() != null) {
            source.homonChosaSakiYubinno = 先頭Entity.get調査先郵便番号();
        }
        if (先頭Entity.get調査先住所() != null) {
            source.homonChosaSakiJusho = 先頭Entity.get調査先住所();
        }
        if (先頭Entity.get調査先名称() != null) {
            source.homonChosaSakiName = 先頭Entity.get調査先名称();
        }
        if (先頭Entity.get調査先電話番号() != null) {
            source.homonChosaSakiTelNo = 先頭Entity.get調査先電話番号();
        }
        if (先頭Entity.get備考() != null) {
            source.biko = 先頭Entity.get備考();
        }
        return source;
    }

    private JukyushaDaichoReportSource get要介護認定情報1(JukyushaDaichoReportSource source,
            YokaigoNinteiJohoEntity 要介護認定情報Entity) {
        if (要介護認定情報Entity.get調査依頼日() != null) {
            source.listNinteiUpper_6 = 要介護認定情報Entity.get調査依頼日().wareki().toDateString();
        }
        if (要介護認定情報Entity.get調査予定日() != null) {
            source.listNinteiUpper_7 = 要介護認定情報Entity.get調査予定日().wareki().toDateString();
        }
        if (要介護認定情報Entity.get調査実施日() != null) {
            source.listNinteiUpper_8 = 要介護認定情報Entity.get調査実施日().wareki().toDateString();
        }
        if (要介護認定情報Entity.get医師依頼日() != null) {
            source.listNinteiCenter_6 = 要介護認定情報Entity.get医師依頼日().wareki().toDateString();
        }
        if (要介護認定情報Entity.get医師予定日() != null) {
            source.listNinteiCenter_7 = 要介護認定情報Entity.get医師予定日().wareki().toDateString();
        }
        if (要介護認定情報Entity.get医師取寄日() != null) {
            source.listNinteiCenter_8 = 要介護認定情報Entity.get医師取寄日().wareki().toDateString();
        }
        if (要介護認定情報Entity.get資料作成日() != null) {
            source.listNinteiLower_5 = 要介護認定情報Entity.get資料作成日().wareki().toDateString();
        }
        if (要介護認定情報Entity.get審査予定日() != null) {
            source.listNinteiLower_6 = 要介護認定情報Entity.get審査予定日().wareki().toDateString();
        }
        if (要介護認定情報Entity.get二次判定日() != null) {
            source.listNinteiLower_7 = 要介護認定情報Entity.get二次判定日().wareki().toDateString();
        }
        if (要介護認定情報Entity.get一次要介護度() != null) {
            source.listNinteiUpper_9 = 要介護認定情報Entity.get一次要介護度();
        }
        if (要介護認定情報Entity.get一次判定日() != null) {
            source.listNinteiCenter_9 = 要介護認定情報Entity.get一次判定日().wareki().toDateString();
        }
        if (要介護認定情報Entity.get一次要介護度_重() != null) {
            source.listNinteiLower_8 = 要介護認定情報Entity.get一次要介護度_重();
        }
        if (要介護認定情報Entity.get旧措置() != null) {
            source.listNinteiUpper_10 = 要介護認定情報Entity.get旧措置();
        }
        if (要介護認定情報Entity.get喪失日() != null) {
            source.listNinteiCenter_10 = 要介護認定情報Entity.get喪失日().wareki().toDateString();
        }
        if (要介護認定情報Entity.get資格取得前申請() != null) {
            source.listNinteiLower_9 = 要介護認定情報Entity.get資格取得前申請();
        }
        if (要介護認定情報Entity.get延期通知書発行日() != null && 要介護認定情報Entity.get延期通知書発行回数() != null) {
            source.listNinteiUpper_11 = 要介護認定情報Entity.get延期通知書発行日().wareki().toDateString().
                    concat(要介護認定情報Entity.get延期通知書発行回数());
        }

        return source;
    }

    private JukyushaDaichoReportSource get要介護認定情報2(JukyushaDaichoReportSource source,
            YokaigoNinteiJohoEntity 要介護認定情報Entity) {
        if (要介護認定情報Entity.get資格証明書発行日１() != null) {
            source.listNinteiCenter_11 = 要介護認定情報Entity.get資格証明書発行日１().wareki().toDateString();
        }
        if (要介護認定情報Entity.get資格証明書発行日２() != null) {
            source.listNinteiLower_10 = 要介護認定情報Entity.get資格証明書発行日２().wareki().toDateString();
        }
        if (要介護認定情報Entity.get特定疾病() != null) {
            source.listNinteiUpper_12 = 要介護認定情報Entity.get特定疾病();
        }
        if (要介護認定情報Entity.get申請代行事業者() != null) {
            source.listNinteiUpper_13 = 要介護認定情報Entity.get申請代行事業者();
        }
        if (要介護認定情報Entity.get代行者コード() != null) {
            source.listNinteiUpper_14 = 要介護認定情報Entity.get代行者コード();
        }
        if (要介護認定情報Entity.get指定医区分() != null) {
            source.listNinteiUpper_15 = 要介護認定情報Entity.get指定医区分();
        }
        if (要介護認定情報Entity.get調査委託先コード() != null && 要介護認定情報Entity.get調査委託先名() != null) {
            source.listNinteiCenter_12 = 要介護認定情報Entity.get調査委託先コード().
                    concat(要介護認定情報Entity.get調査委託先名());
        }
        if (要介護認定情報Entity.get調査員コード() != null && 要介護認定情報Entity.get調査員名() != null) {
            source.listNinteiCenter_13 = 要介護認定情報Entity.get調査員コード().concat(要介護認定情報Entity.get調査員名());
        }
        if (要介護認定情報Entity.get主治医医療機関コード() != null && 要介護認定情報Entity.get主治医医療機関名() != null) {
            source.listNinteiLower_11 = 要介護認定情報Entity.get主治医医療機関コード().
                    concat(要介護認定情報Entity.get主治医医療機関名());
        }
        if (要介護認定情報Entity.get主治医コード() != null && 要介護認定情報Entity.get主治医名() != null) {
            source.listNinteiLower_12 = 要介護認定情報Entity.get主治医コード().concat(要介護認定情報Entity.get主治医名());
        }
        if (要介護認定情報Entity.get認定審査会意見() != null) {
            source.listNinteiCenter_14 = 要介護認定情報Entity.get認定審査会意見();
        }
        if (要介護認定情報Entity.get申請区分_申請時() != null) {
            source.listNinteiUpper_16 = 要介護認定情報Entity.get申請区分_申請時();
        }
        if (要介護認定情報Entity.get申請区分_法令() != null) {
            source.listNinteiLower_13 = 要介護認定情報Entity.get申請区分_法令();
        }
        return source;
    }

    private JukyushaDaichoReportSource get負担限度額認定情報(JukyushaDaichoReportSource source,
            FutanGendogakuNinteiJohoEntity 負担限度額認定情報Entity) {
        if (負担限度額認定情報Entity.getユ個() != null) {
            source.listFutanGendogakuNintei_11 = new RString(負担限度額認定情報Entity.getユ個().toString());
        }
        if (負担限度額認定情報Entity.getユ準() != null) {
            source.listFutanGendogakuNintei_12 = new RString(負担限度額認定情報Entity.getユ準().toString());
        }
        if (負担限度額認定情報Entity.get従特養() != null) {
            source.listFutanGendogakuNintei_13 = new RString(負担限度額認定情報Entity.get従特養().toString());
        }
        if (負担限度額認定情報Entity.get従老健() != null) {
            source.listFutanGendogakuNintei_14 = new RString(負担限度額認定情報Entity.get従老健().toString());
        }
        if (負担限度額認定情報Entity.get多床() != null) {
            source.listFutanGendogakuNintei_15 = new RString(負担限度額認定情報Entity.get多床().toString());
        }
        if (負担限度額認定情報Entity.get境界層() != null) {
            source.listFutanGendogakuNintei_16 = 負担限度額認定情報Entity.get境界層();
        }
        if (負担限度額認定情報Entity.get激変緩和() != null) {
            source.listFutanGendogakuNintei_17 = 負担限度額認定情報Entity.get激変緩和();
        }
        return source;
    }

    private JukyushaDaichoReportSource get資格情報(JukyushaDaichoReportSource source, ShikakujohoEntity 資格情報Entity) {
        if (資格情報Entity.get適用開始日() != null) {
            source.listShikaku_11 = 資格情報Entity.get適用開始日().wareki().toDateString();
        }
        if (資格情報Entity.get適用届出日() != null) {
            source.listShikaku_12 = 資格情報Entity.get適用届出日().wareki().toDateString();
        }
        if (資格情報Entity.get適用事由() != null) {
            source.listShikaku_13 = 資格情報Entity.get適用事由().get名称();
        }
        if (資格情報Entity.get解除開始日() != null) {
            source.listShikaku_14 = 資格情報Entity.get解除開始日().wareki().toDateString();
        }
        if (資格情報Entity.get解除届出日() != null) {
            source.listShikaku_15 = 資格情報Entity.get解除届出日().wareki().toDateString();
        }
        if (資格情報Entity.get解除事由() != null) {
            source.listShikaku_16 = 資格情報Entity.get解除事由().get名称();
        }
        return source;
    }
}
