/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuoshirasetsuchiteshutsukigenari;

import jp.co.ndensan.reams.db.dbc.business.report.util.ReportKomokuEditorUtil;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuoshirasetsuchiteshutsukigenari.KogakuOshiraseTsuchiTeshutsuKigenAriEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuoshirasetsuchiteshutsukigenari.KogakuOshiraseTsuchiTeshutsuKigenAriSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス給付のお知らせ通知書（提出期限あり）のソースの編集クラスです。
 *
 * @reamsid_L DBC-4770-040 zhujun
 */
public class KogakuOshiraseTsuchiTeshutsuKigenAriEditor implements IKogakuOshiraseTsuchiTeshutsuKigenAriEditor {

    private final KogakuOshiraseTsuchiTeshutsuKigenAriEntity target;

    /**
     * コンストラクタです。
     *
     * @param target target
     */
    public KogakuOshiraseTsuchiTeshutsuKigenAriEditor(KogakuOshiraseTsuchiTeshutsuKigenAriEntity target) {
        this.target = target;
    }

    @Override
    public KogakuOshiraseTsuchiTeshutsuKigenAriSource edit(KogakuOshiraseTsuchiTeshutsuKigenAriSource source) {
        source.bunshoNo = target.get文書番号文字列();
        source.title = target.getタイトル();
        source.tsuchibun1 = target.get通知文1();
        source.tsuchibun2 = target.get通知文2();
        if (!target.is空白()) {
            source.hihokenshaNameKana = ReportKomokuEditorUtil.get氏名カナ(target.get申請情報帳票発行一時().getShimeikanaChohyo());
            source.hihokenshaName = ReportKomokuEditorUtil.get氏名(target.get申請情報帳票発行一時().getMeishoChohyo());
            source.man = get性別(target.get申請情報帳票発行一時().getSeibetsuCodeChohyo());
            source.birthYMD = ReportKomokuEditorUtil.パターン12(target.get申請情報帳票発行一時().getSeinengappiYMDChohyo());
            source.hokenshaNo = ReportKomokuEditorUtil.get証記載保険者番号(target.get申請情報帳票発行一時().getShoKisaiHokenshaNoChohyo());
            source.hihokenshaNo = ReportKomokuEditorUtil.get被保険者番号(target.get申請情報帳票発行一時().getHihokenshaNoChohyo());
            source.taishoYM = ReportKomokuEditorUtil.パターン62(target.get申請情報帳票発行一時().getServiceTeikyoYMChohyo());
            // TODO QA.1189あり 利用者負担額と高額支給額は、一時表に存在しない
//        source.zikoFutanGaku = ReportKomokuEditorUtil.金額1(target.get申請情報帳票発行一時().getRiyoshaFutanGakuGokeiChohyo());
//        source.ketteiGaku = 
//        source.shikyuGaku = 
            source.kigenYMD = ReportKomokuEditorUtil.パターン12(target.get申請書提出期限());
            source.remban = target.get連番();

            if (target.get認証者() != null) {
                source.hakkoYMD = target.get認証者().hakkoYMD;
                source.denshiKoin = target.get認証者().denshiKoin;
                source.koinMojiretsu = target.get認証者().koinMojiretsu;
                source.koinShoryaku = target.get認証者().koinShoryaku;
                source.ninshoshaShimeiKakenai = target.get認証者().ninshoshaShimeiKakenai;
                source.ninshoshaShimeiKakeru = target.get認証者().ninshoshaShimeiKakeru;
                source.ninshoshaYakushokuMei = target.get認証者().ninshoshaYakushokuMei;
            }

            source.yubinNo = target.get送付別宛先().yubinNo;
            source.gyoseiku2 = target.get送付別宛先().gyoseiku;
            source.jusho4 = target.get送付別宛先().jusho1;
            source.jushoText = target.get送付別宛先().jushoText;
            source.jusho5 = target.get送付別宛先().jusho2;
            source.jusho6 = target.get送付別宛先().jusho3;
            source.katagakiText = target.get送付別宛先().katagakiText;
            source.katagaki3 = target.get送付別宛先().katagaki1;
            source.katagakiSmall2 = target.get送付別宛先().katagakiSmall2;
            source.katagaki4 = target.get送付別宛先().katagaki2;
            source.katagakiSmall1 = target.get送付別宛先().katagakiSmall1;
            source.shimei5 = target.get送付別宛先().shimei1;
            source.shimeiSmall2 = target.get送付別宛先().shimeiSmall2;
            source.shimeiText = target.get送付別宛先().shimeiText;
            source.meishoFuyo2 = target.get送付別宛先().meishoFuyo2;
            source.shimeiSmall1 = target.get送付別宛先().shimeiSmall1;
            source.dainoKubunMei = target.get送付別宛先().dainoKubunMei;
            source.shimei6 = target.get送付別宛先().shimei2;
            source.meishoFuyo1 = target.get送付別宛先().meishoFuyo1;
            source.samabunShimeiText = target.get送付別宛先().samabunShimeiText;
            source.samaBun2 = target.get送付別宛先().samaBun2;
            source.samabunShimeiSmall2 = target.get送付別宛先().kakkoLeft2;
            source.kakkoLeft2 = target.get送付別宛先().samabunShimei2;
            source.samabunShimei2 = target.get送付別宛先().samabunShimeiSmall2;
            source.kakkoRight2 = target.get送付別宛先().kakkoRight2;
            source.kakkoLeft1 = target.get送付別宛先().kakkoLeft1;
            source.samabunShimei1 = target.get送付別宛先().samabunShimei1;
            source.samaBun1 = target.get送付別宛先().samaBun1;
            source.kakkoRight1 = target.get送付別宛先().kakkoRight1;
            source.samabunShimeiSmall1 = target.get送付別宛先().samabunShimeiSmall1;
            source.customerBarCode = target.get送付別宛先().customerBarCode;

            source.識別コード = target.get申請情報帳票発行一時().getShikibetsuCodeChohyo();
        }
        return source;
    }

    private RString get性別(RString code) {
        if (RString.isNullOrEmpty(code)) {
            return RString.EMPTY;
        }
        return Seibetsu.男.getコード().equals(code) ? Seibetsu.男.get名称() : Seibetsu.女.get名称();
    }
}
