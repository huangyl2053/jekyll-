package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告月報補正表示を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 liangbc
 */
public enum JigyohokokuGeppoHoseiHyoji {

    /**
     * コード:001 名称:保険者／第１号被保険者数・第１号被保険者増減内訳 略称:定義なし
     */
    保険者_第１号被保険者数_第１号被保険者増減内訳("001", "保険者／第１号被保険者数・第１号被保険者増減内訳"),
    /**
     * コード:002 名称:保険者／食費・居住費に係る負担限度額認定（総括） 略称:定義なし
     */
    保険者_食費_居住費に係る負担限度額認定_総括("002", "保険者／食費・居住費に係る負担限度額認定（総括）"),
    /**
     * コード:003 名称:保険者／食費・居住費に係る負担限度額認定（再掲：第２号分） 略称:定義なし
     */
    保険者_食費_居住費に係る負担限度額認定_再掲_第２号分("003", "保険者／食費・居住費に係る負担限度額認定（再掲：第２号分）"),
    /**
     * コード:004 名称:保険者／利用者負担減額・免除認定（総括） 略称:定義なし
     */
    保険者_利用者負担減額_免除認定_総括("004", "保険者／利用者負担減額・免除認定（総括）"),
    /**
     * コード:005 名称:保険者／利用者負担減額・免除認定（再掲：第２号分） 略称:定義なし
     */
    保険者_利用者負担減額_免除認定_再掲_第２号分("005", "保険者／利用者負担減額・免除認定（再掲：第２号分）"),
    /**
     * コード:006 名称:保険者／介護老人福祉施設旧措置入所者減額・免除認定（総括） 略称:定義なし
     */
    保険者_介護老人福祉施設旧措置入所者減額_免除認定_総括("006", "保険者／介護老人福祉施設旧措置入所者減額・免除認定（総括）"),
    /**
     * コード:007 名称:保険者／介護老人福祉施設旧措置入所者減額・免除認定（再掲：第２号分） 略称:定義なし
     */
    保険者_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分("007", "保険者／介護老人福祉施設旧措置入所者減額・免除認定（再掲：第２号分）"),
    /**
     * コード:008 名称:保険者／食費・居住費負担限度額認定（再掲：税制改正激変緩和者） 略称:定義なし
     */
    保険者_食費_居住費負担限度額認定_再掲_税制改正激変緩和者("008", "保険者／食費・居住費負担限度額認定（再掲：税制改正激変緩和者）"),
    /**
     * コード:009 名称:保険者／利用者負担第４段階食費・居住費の特例減額措置 略称:定義なし
     */
    保険者_利用者負担第４段階食費_居住費の特例減額措置("009", "保険者／利用者負担第４段階食費・居住費の特例減額措置"),
    /**
     * コード:010 名称:保険者／要介護（要支援）認定者数 略称:定義なし
     */
    保険者_要介護_要支援_認定者数("010", "保険者／要介護（要支援）認定者数"),
    /**
     * コード:011 名称:保険者／現物分／居宅介護（介護予防）サービス受給者数 略称:定義なし
     */
    保険者_現物分_居宅介護_介護予防_サービス受給者数("011", "保険者／現物分／居宅介護（介護予防）サービス受給者数"),
    /**
     * コード:012 名称:保険者／償還（審査年月）／居宅介護（介護予防）サービス受給者数 略称:定義なし
     */
    保険者_償還_審査年月__居宅介護_介護予防_サービス受給者数("012", "保険者／償還（審査年月）／居宅介護（介護予防）サービス受給者数"),
    /**
     * コード:013 名称:保険者／償還（決定年月）／居宅介護（介護予防）サービス受給者数 略称:定義なし
     */
    保険者_償還_決定年月__居宅介護_介護予防_サービス受給者数("013", "保険者／償還（決定年月）／居宅介護（介護予防）サービス受給者数"),
    /**
     * コード:014 名称:保険者／現物分／地域密着型（介護予防）サービス受給者数 略称:定義なし
     */
    保険者_現物分_地域密着型_介護予防_サービス受給者数("014", "保険者／現物分／地域密着型（介護予防）サービス受給者数"),
    /**
     * コード:015 名称:保険者／償還（審査年月）／地域密着型（介護予防）サービス受給者数 略称:定義なし
     */
    保険者_償還_審査年月__地域密着型_介護予防_サービス受給者数("015", "保険者／償還（審査年月）／地域密着型（介護予防）サービス受給者数"),
    /**
     * コード:016 名称:保険者／償還（決定年月）／地域密着型（介護予防）サービス受給者数 略称:定義なし
     */
    保険者_償還_決定年月__地域密着型_介護予防_サービス受給者数("016", "保険者／償還（決定年月）／地域密着型（介護予防）サービス受給者数"),
    /**
     * コード:017 名称:保険者／現物分／施設介護サービス受給者数 略称:定義なし
     */
    保険者_現物分_施設介護サービス受給者数("017", "保険者／現物分／施設介護サービス受給者数"),
    /**
     * コード:018 名称:保険者／償還（審査年月）／施設介護サービス受給者数 略称:定義なし
     */
    保険者_償還_審査年月__施設介護サービス受給者数("018", "保険者／償還（審査年月）／施設介護サービス受給者数"),
    /**
     * コード:019 名称:保険者／償還（決定年月）／施設介護サービス受給者数 略称:定義なし
     */
    保険者_償還_決定年月__施設介護サービス受給者数("019", "保険者／償還（決定年月）／施設介護サービス受給者数"),
    /**
     * コード:020 名称:保険者／（別紙）第１号被保険者のいる世帯 略称:定義なし
     */
    保険者__別紙_第１号被保険者のいる世帯("020", "保険者／（別紙）第１号被保険者のいる世帯"),
    /**
     * コード:021 名称:保険者／現物分／介護給付・予防給付①総数 略称:定義なし
     */
    保険者_現物分_介護給付_予防給付1総数("021", "保険者／現物分／介護給付・予防給付①総数"),
    /**
     * コード:022 名称:保険者／現物分／介護給付・予防給付②第２号被保険者分（再掲） 略称:定義なし
     */
    保険者_現物分_介護給付_予防給付2第２号被保険者分_再掲("022", "保険者／現物分／介護給付・予防給付②第２号被保険者分（再掲）"),
    /**
     * コード:023 名称:保険者／現物分／介護給付・予防給付③総数特例分 略称:定義なし
     */
    保険者_現物分_介護給付_予防給付3総数特例分("023", "保険者／現物分／介護給付・予防給付③総数特例分"),
    /**
     * コード:024 名称:保険者／現物分／介護給付・予防給付④第２号被保険者分（再掲：特例分） 略称:定義なし
     */
    保険者_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分("024", "保険者／現物分／介護給付・予防給付④第２号被保険者分（再掲：特例分）"),
    /**
     * コード:025 名称:保険者／償還（審査年月）／介護給付・予防給付①総数 略称:定義なし
     */
    保険者_償還_審査年月__介護給付_予防給付1総数("025", "保険者／償還（審査年月）／介護給付・予防給付①総数"),
    /**
     * コード:026 名称:保険者／償還（審査年月）／介護給付・予防給付②第２号被保険者分（再掲） 略称:定義なし
     */
    保険者_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲("026", "保険者／償還（審査年月）／介護給付・予防給付②第２号被保険者分（再掲）"),
    /**
     * コード:027 名称:保険者／償還（審査年月）／介護給付・予防給付③総数特例分 略称:定義なし
     */
    保険者_償還_審査年月__介護給付_予防給付3総数特例分("027", "保険者／償還（審査年月）／介護給付・予防給付③総数特例分"),
    /**
     * コード:028 名称:保険者／償還（審査年月）／介護給付・予防給付④第２号被保険者分（再掲：特例分） 略称:定義なし
     */
    保険者_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分("028", "保険者／償還（審査年月）／介護給付・予防給付④第２号被保険者分（再掲：特例分）"),
    /**
     * コード:029 名称:保険者／償還（決定年月）／介護給付・予防給付①総数 略称:定義なし
     */
    保険者_償還_決定年月__介護給付_予防給付1総数("029", "保険者／償還（決定年月）／介護給付・予防給付①総数"),
    /**
     * コード:030 名称:保険者／償還（決定年月）／介護給付・予防給付②第２号被保険者分（再掲） 略称:定義なし
     */
    保険者_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲("030", "保険者／償還（決定年月）／介護給付・予防給付②第２号被保険者分（再掲）"),
    /**
     * コード:031 名称:保険者／償還（決定年月）／介護給付・予防給付③総数特例分 略称:定義なし
     */
    保険者_償還_決定年月__介護給付_予防給付3総数特例分("031", "保険者／償還（決定年月）／介護給付・予防給付③総数特例分"),
    /**
     * コード:032 名称:保険者／償還（決定年月）／介護給付・予防給付④第２号被保険者分（再掲：特例分） 略称:定義なし
     */
    保険者_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分("032", "保険者／償還（決定年月）／介護給付・予防給付④第２号被保険者分（再掲：特例分）"),
    /**
     * コード:033 名称:保険者／現物分／特定入所者介護（介護予防）サービス費①総数 略称:定義なし
     */
    保険者_現物分_特定入所者介護_介護予防_サービス費1総数("033", "保険者／現物分／特定入所者介護（介護予防）サービス費①総数"),
    /**
     * コード:034 名称:保険者／現物分／特定入所者介護（介護予防）サービス費②第２号被保険者分 略称:定義なし
     */
    保険者_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分("034", "保険者／現物分／特定入所者介護（介護予防）サービス費②第２号被保険者分"),
    /**
     * コード:035 名称:保険者／償還（審査年月）／特定入所者介護（介護予防）サービス費①総数 略称:定義なし
     */
    保険者_償還_審査年月__特定入所者介護_介護予防_サービス費1総数("035", "保険者／償還（審査年月）／特定入所者介護（介護予防）サービス費①総数"),
    /**
     * コード:036 名称:保険者／償還（審査年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分 略称:定義なし
     */
    保険者_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分("036", "保険者／償還（審査年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分"),
    /**
     * コード:037 名称:保険者／償還（決定年月）／特定入所者介護（介護予防）サービス費①総数 略称:定義なし
     */
    保険者_償還_決定年月__特定入所者介護_介護予防_サービス費1総数("037", "保険者／償還（決定年月）／特定入所者介護（介護予防）サービス費①総数"),
    /**
     * コード:038 名称:保険者／償還（決定年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分 略称:定義なし
     */
    保険者_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分("038", "保険者／償還（決定年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分"),
    /**
     * コード:039 名称:保険者／高額介護（介護予防）サービス費 略称:定義なし
     */
    保険者_高額介護_介護予防_サービス費("039", "保険者／高額介護（介護予防）サービス費"),
    /**
     * コード:040 名称:保険者／高額医療合算介護（介護予防）サービス費 略称:定義なし
     */
    保険者_高額医療合算介護_介護予防_サービス費("040", "保険者／高額医療合算介護（介護予防）サービス費"),
    /**
     * コード:101 名称:構成市町村／第１号被保険者数・第１号被保険者増減内訳 略称:定義なし
     */
    構成市町村_第１号被保険者数_第１号被保険者増減内訳("101", "構成市町村／第１号被保険者数・第１号被保険者増減内訳"),
    /**
     * コード:102 名称:構成市町村／食費・居住費に係る負担限度額認定（総括） 略称:定義なし
     */
    構成市町村_食費_居住費に係る負担限度額認定_総括("102", "構成市町村／食費・居住費に係る負担限度額認定（総括）"),
    /**
     * コード:103 名称:構成市町村／食費・居住費に係る負担限度額認定（再掲：第２号分） 略称:定義なし
     */
    構成市町村_食費_居住費に係る負担限度額認定_再掲_第２号分("103", "構成市町村／食費・居住費に係る負担限度額認定（再掲：第２号分）"),
    /**
     * コード:104 名称:構成市町村／利用者負担減額・免除認定（総括） 略称:定義なし
     */
    構成市町村_利用者負担減額_免除認定_総括("104", "構成市町村／利用者負担減額・免除認定（総括）"),
    /**
     * コード:105 名称:構成市町村／利用者負担減額・免除認定（再掲：第２号分） 略称:定義なし
     */
    構成市町村_利用者負担減額_免除認定_再掲_第２号分("105", "構成市町村／利用者負担減額・免除認定（再掲：第２号分）"),
    /**
     * コード:106 名称:構成市町村／介護老人福祉施設旧措置入所者減額・免除認定（総括） 略称:定義なし
     */
    構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括("106", "構成市町村／介護老人福祉施設旧措置入所者減額・免除認定（総括）"),
    /**
     * コード:107 名称:構成市町村／介護老人福祉施設旧措置入所者減額・免除認定（再掲：第２号分） 略称:定義なし
     */
    構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分("107", "構成市町村／介護老人福祉施設旧措置入所者減額・免除認定（再掲：第２号分）"),
    /**
     * コード:108 名称:構成市町村／食費・居住費負担限度額認定（再掲：税制改正激変緩和者） 略称:定義なし
     */
    構成市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者("108", "構成市町村／食費・居住費負担限度額認定（再掲：税制改正激変緩和者）"),
    /**
     * コード:109 名称:構成市町村／利用者負担第４段階食費・居住費の特例減額措置 略称:定義なし
     */
    構成市町村_利用者負担第４段階食費_居住費の特例減額措置("109", "構成市町村／利用者負担第４段階食費・居住費の特例減額措置"),
    /**
     * コード:110 名称:構成市町村／要介護（要支援）認定者数 略称:定義なし
     */
    構成市町村_要介護_要支援_認定者数("110", "構成市町村／要介護（要支援）認定者数"),
    /**
     * コード:111 名称:構成市町村／現物分／居宅介護（介護予防）サービス受給者数 略称:定義なし
     */
    構成市町村_現物分_居宅介護_介護予防_サービス受給者数("111", "構成市町村／現物分／居宅介護（介護予防）サービス受給者数"),
    /**
     * コード:112 名称:構成市町村／償還（審査年月）／居宅介護（介護予防）サービス受給者数 略称:定義なし
     */
    構成市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数("112", "構成市町村／償還（審査年月）／居宅介護（介護予防）サービス受給者数"),
    /**
     * コード:113 名称:構成市町村／償還（決定年月）／居宅介護（介護予防）サービス受給者数 略称:定義なし
     */
    構成市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数("113", "構成市町村／償還（決定年月）／居宅介護（介護予防）サービス受給者数"),
    /**
     * コード:114 名称:構成市町村／現物分／地域密着型（介護予防）サービス受給者数 略称:定義なし
     */
    構成市町村_現物分_地域密着型_介護予防_サービス受給者数("114", "構成市町村／現物分／地域密着型（介護予防）サービス受給者数"),
    /**
     * コード:115 名称:構成市町村／償還（審査年月）／地域密着型（介護予防）サービス受給者数 略称:定義なし
     */
    構成市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数("115", "構成市町村／償還（審査年月）／地域密着型（介護予防）サービス受給者数"),
    /**
     * コード:116 名称:構成市町村／償還（決定年月）／地域密着型（介護予防）サービス受給者数 略称:定義なし
     */
    構成市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数("116", "構成市町村／償還（決定年月）／地域密着型（介護予防）サービス受給者数"),
    /**
     * コード:117 名称:構成市町村／現物分／施設介護サービス受給者数 略称:定義なし
     */
    構成市町村_現物分_施設介護サービス受給者数("117", "構成市町村／現物分／施設介護サービス受給者数"),
    /**
     * コード:118 名称:構成市町村／償還（審査年月）／施設介護サービス受給者数 略称:定義なし
     */
    構成市町村_償還_審査年月__施設介護サービス受給者数("118", "構成市町村／償還（審査年月）／施設介護サービス受給者数"),
    /**
     * コード:119 名称:構成市町村／償還（決定年月）／施設介護サービス受給者数 略称:定義なし
     */
    構成市町村_償還_決定年月__施設介護サービス受給者数("119", "構成市町村／償還（決定年月）／施設介護サービス受給者数"),
    /**
     * コード:120 名称:構成市町村／（別紙）第１号被保険者のいる世帯 略称:定義なし
     */
    構成市町村__別紙_第１号被保険者のいる世帯("120", "構成市町村／（別紙）第１号被保険者のいる世帯"),
    /**
     * コード:121 名称:構成市町村／現物分／介護給付・予防給付①総数 略称:定義なし
     */
    構成市町村_現物分_介護給付_予防給付1総数("121", "構成市町村／現物分／介護給付・予防給付①総数"),
    /**
     * コード:122 名称:構成市町村／現物分／介護給付・予防給付②第２号被保険者分（再掲） 略称:定義なし
     */
    構成市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲("122", "構成市町村／現物分／介護給付・予防給付②第２号被保険者分（再掲）"),
    /**
     * コード:123 名称:構成市町村／現物分／介護給付・予防給付③総数特例分 略称:定義なし
     */
    構成市町村_現物分_介護給付_予防給付3総数特例分("123", "構成市町村／現物分／介護給付・予防給付③総数特例分"),
    /**
     * コード:124 名称:構成市町村／現物分／介護給付・予防給付④第２号被保険者分（再掲：特例分） 略称:定義なし
     */
    構成市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分("124", "構成市町村／現物分／介護給付・予防給付④第２号被保険者分（再掲：特例分）"),
    /**
     * コード:125 名称:構成市町村／償還（審査年月）／介護給付・予防給付①総数 略称:定義なし
     */
    構成市町村_償還_審査年月__介護給付_予防給付1総数("125", "構成市町村／償還（審査年月）／介護給付・予防給付①総数"),
    /**
     * コード:126 名称:構成市町村／償還（審査年月）／介護給付・予防給付②第２号被保険者分（再掲） 略称:定義なし
     */
    構成市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲("126", "構成市町村／償還（審査年月）／介護給付・予防給付②第２号被保険者分（再掲）"),
    /**
     * コード:127 名称:構成市町村／償還（審査年月）／介護給付・予防給付③総数特例分 略称:定義なし
     */
    構成市町村_償還_審査年月__介護給付_予防給付3総数特例分("127", "構成市町村／償還（審査年月）／介護給付・予防給付③総数特例分"),
    /**
     * コード:128 名称:構成市町村／償還（審査年月）／介護給付・予防給付④第２号被保険者分（再掲：特例分） 略称:定義なし
     */
    構成市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分("128", "構成市町村／償還（審査年月）／介護給付・予防給付④第２号被保険者分（再掲：特例分）"),
    /**
     * コード:129 名称:構成市町村／償還（決定年月）／介護給付・予防給付①総数 略称:定義なし
     */
    構成市町村_償還_決定年月__介護給付_予防給付1総数("129", "構成市町村／償還（決定年月）／介護給付・予防給付①総数"),
    /**
     * コード:130 名称:構成市町村／償還（決定年月）／介護給付・予防給付②第２号被保険者分（再掲） 略称:定義なし
     */
    構成市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲("130", "構成市町村／償還（決定年月）／介護給付・予防給付②第２号被保険者分（再掲）"),
    /**
     * コード:131 名称:構成市町村／償還（決定年月）／介護給付・予防給付③総数特例分 略称:定義なし
     */
    構成市町村_償還_決定年月__介護給付_予防給付3総数特例分("131", "構成市町村／償還（決定年月）／介護給付・予防給付③総数特例分"),
    /**
     * コード:132 名称:構成市町村／償還（決定年月）／介護給付・予防給付④第２号被保険者分（再掲：特例分） 略称:定義なし
     */
    構成市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分("132", "構成市町村／償還（決定年月）／介護給付・予防給付④第２号被保険者分（再掲：特例分）"),
    /**
     * コード:133 名称:構成市町村／現物分／特定入所者介護（介護予防）サービス費①総数 略称:定義なし
     */
    構成市町村_現物分_特定入所者介護_介護予防_サービス費1総数("133", "構成市町村／現物分／特定入所者介護（介護予防）サービス費①総数"),
    /**
     * コード:134 名称:構成市町村／現物分／特定入所者介護（介護予防）サービス費②第２号被保険者分 略称:定義なし
     */
    構成市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分("134", "構成市町村／現物分／特定入所者介護（介護予防）サービス費②第２号被保険者分"),
    /**
     * コード:135 名称:構成市町村／償還（審査年月）／特定入所者介護（介護予防）サービス費①総数 略称:定義なし
     */
    構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数("135", "構成市町村／償還（審査年月）／特定入所者介護（介護予防）サービス費①総数"),
    /**
     * コード:136 名称:構成市町村／償還（審査年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分 略称:定義なし
     */
    構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分("136", "構成市町村／償還（審査年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分"),
    /**
     * コード:137 名称:構成市町村／償還（決定年月）／特定入所者介護（介護予防）サービス費①総数 略称:定義なし
     */
    構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数("137", "構成市町村／償還（決定年月）／特定入所者介護（介護予防）サービス費①総数"),
    /**
     * コード:138 名称:構成市町村／償還（決定年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分 略称:定義なし
     */
    構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分("138", "構成市町村／償還（決定年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分"),
    /**
     * コード:139 名称:構成市町村／高額介護（介護予防）サービス費 略称:定義なし
     */
    構成市町村_高額介護_介護予防_サービス費("139", "構成市町村／高額介護（介護予防）サービス費"),
    /**
     * コード:140 名称:構成市町村／高額医療合算介護（介護予防）サービス費 略称:定義なし
     */
    構成市町村_高額医療合算介護_介護予防_サービス費("140", "構成市町村／高額医療合算介護（介護予防）サービス費"),
    /**
     * コード:201 名称:旧市町村／第１号被保険者数・第１号被保険者増減内訳 略称:定義なし
     */
    旧市町村_第１号被保険者数_第１号被保険者増減内訳("201", "旧市町村／第１号被保険者数・第１号被保険者増減内訳"),
    /**
     * コード:202 名称:旧市町村／食費・居住費に係る負担限度額認定（総括） 略称:定義なし
     */
    旧市町村_食費_居住費に係る負担限度額認定_総括("202", "旧市町村／食費・居住費に係る負担限度額認定（総括）"),
    /**
     * コード:203 名称:旧市町村／食費・居住費に係る負担限度額認定（再掲：第２号分） 略称:定義なし
     */
    旧市町村_食費_居住費に係る負担限度額認定_再掲_第２号分("203", "旧市町村／食費・居住費に係る負担限度額認定（再掲：第２号分）"),
    /**
     * コード:204 名称:旧市町村／利用者負担減額・免除認定（総括） 略称:定義なし
     */
    旧市町村_利用者負担減額_免除認定_総括("204", "旧市町村／利用者負担減額・免除認定（総括）"),
    /**
     * コード:205 名称:旧市町村／利用者負担減額・免除認定（再掲：第２号分） 略称:定義なし
     */
    旧市町村_利用者負担減額_免除認定_再掲_第２号分("205", "旧市町村／利用者負担減額・免除認定（再掲：第２号分）"),
    /**
     * コード:206 名称:旧市町村／介護老人福祉施設旧措置入所者減額・免除認定（総括） 略称:定義なし
     */
    旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括("206", "旧市町村／介護老人福祉施設旧措置入所者減額・免除認定（総括）"),
    /**
     * コード:207 名称:旧市町村／介護老人福祉施設旧措置入所者減額・免除認定（再掲：第２号分） 略称:定義なし
     */
    旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分("207", "旧市町村／介護老人福祉施設旧措置入所者減額・免除認定（再掲：第２号分）"),
    /**
     * コード:208 名称:旧市町村／食費・居住費負担限度額認定（再掲：税制改正激変緩和者） 略称:定義なし
     */
    旧市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者("208", "旧市町村／食費・居住費負担限度額認定（再掲：税制改正激変緩和者）"),
    /**
     * コード:209 名称:旧市町村／利用者負担第４段階食費・居住費の特例減額措置 略称:定義なし
     */
    旧市町村_利用者負担第４段階食費_居住費の特例減額措置("209", "旧市町村／利用者負担第４段階食費・居住費の特例減額措置"),
    /**
     * コード:210 名称:旧市町村／要介護（要支援）認定者数 略称:定義なし
     */
    旧市町村_要介護_要支援_認定者数("210", "旧市町村／要介護（要支援）認定者数"),
    /**
     * コード:211 名称:旧市町村／現物分／居宅介護（介護予防）サービス受給者数 略称:定義なし
     */
    旧市町村_現物分_居宅介護_介護予防_サービス受給者数("211", "旧市町村／現物分／居宅介護（介護予防）サービス受給者数"),
    /**
     * コード:212 名称:旧市町村／償還（審査年月）／居宅介護（介護予防）サービス受給者数 略称:定義なし
     */
    旧市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数("212", "旧市町村／償還（審査年月）／居宅介護（介護予防）サービス受給者数"),
    /**
     * コード:213 名称:旧市町村／償還（決定年月）／居宅介護（介護予防）サービス受給者数 略称:定義なし
     */
    旧市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数("213", "旧市町村／償還（決定年月）／居宅介護（介護予防）サービス受給者数"),
    /**
     * コード:214 名称:旧市町村／現物分／地域密着型（介護予防）サービス受給者数 略称:定義なし
     */
    旧市町村_現物分_地域密着型_介護予防_サービス受給者数("214", "旧市町村／現物分／地域密着型（介護予防）サービス受給者数"),
    /**
     * コード:215 名称:旧市町村／償還（審査年月）／地域密着型（介護予防）サービス受給者数 略称:定義なし
     */
    旧市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数("215", "旧市町村／償還（審査年月）／地域密着型（介護予防）サービス受給者数"),
    /**
     * コード:216 名称:旧市町村／償還（決定年月）／地域密着型（介護予防）サービス受給者数 略称:定義なし
     */
    旧市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数("216", "旧市町村／償還（決定年月）／地域密着型（介護予防）サービス受給者数"),
    /**
     * コード:217 名称:旧市町村／現物分／施設介護サービス受給者数 略称:定義なし
     */
    旧市町村_現物分_施設介護サービス受給者数("217", "旧市町村／現物分／施設介護サービス受給者数"),
    /**
     * コード:218 名称:旧市町村／償還（審査年月）／施設介護サービス受給者数 略称:定義なし
     */
    旧市町村_償還_審査年月__施設介護サービス受給者数("218", "旧市町村／償還（審査年月）／施設介護サービス受給者数"),
    /**
     * コード:219 名称:旧市町村／償還（決定年月）／施設介護サービス受給者数 略称:定義なし
     */
    旧市町村_償還_決定年月__施設介護サービス受給者数("219", "旧市町村／償還（決定年月）／施設介護サービス受給者数"),
    /**
     * コード:220 名称:旧市町村／（別紙）第１号被保険者のいる世帯 略称:定義なし
     */
    旧市町村__別紙_第１号被保険者のいる世帯("220", "旧市町村／（別紙）第１号被保険者のいる世帯"),
    /**
     * コード:221 名称:旧市町村／現物分／介護給付・予防給付①総数 略称:定義なし
     */
    旧市町村_現物分_介護給付_予防給付1総数("221", "旧市町村／現物分／介護給付・予防給付①総数"),
    /**
     * コード:222 名称:旧市町村／現物分／介護給付・予防給付②第２号被保険者分（再掲） 略称:定義なし
     */
    旧市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲("222", "旧市町村／現物分／介護給付・予防給付②第２号被保険者分（再掲）"),
    /**
     * コード:223 名称:旧市町村／現物分／介護給付・予防給付③総数特例分 略称:定義なし
     */
    旧市町村_現物分_介護給付_予防給付3総数特例分("223", "旧市町村／現物分／介護給付・予防給付③総数特例分"),
    /**
     * コード:224 名称:旧市町村／現物分／介護給付・予防給付④第２号被保険者分（再掲：特例分） 略称:定義なし
     */
    旧市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分("224", "旧市町村／現物分／介護給付・予防給付④第２号被保険者分（再掲：特例分）"),
    /**
     * コード:225 名称:旧市町村／償還（審査年月）／介護給付・予防給付①総数 略称:定義なし
     */
    旧市町村_償還_審査年月__介護給付_予防給付1総数("225", "旧市町村／償還（審査年月）／介護給付・予防給付①総数"),
    /**
     * コード:226 名称:旧市町村／償還（審査年月）／介護給付・予防給付②第２号被保険者分（再掲） 略称:定義なし
     */
    旧市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲("226", "旧市町村／償還（審査年月）／介護給付・予防給付②第２号被保険者分（再掲）"),
    /**
     * コード:227 名称:旧市町村／償還（審査年月）／介護給付・予防給付③総数特例分 略称:定義なし
     */
    旧市町村_償還_審査年月__介護給付_予防給付3総数特例分("227", "旧市町村／償還（審査年月）／介護給付・予防給付③総数特例分"),
    /**
     * コード:228 名称:旧市町村／償還（審査年月）／介護給付・予防給付④第２号被保険者分（再掲：特例分） 略称:定義なし
     */
    旧市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分("228", "旧市町村／償還（審査年月）／介護給付・予防給付④第２号被保険者分（再掲：特例分）"),
    /**
     * コード:229 名称:旧市町村／償還（決定年月）／介護給付・予防給付①総数 略称:定義なし
     */
    旧市町村_償還_決定年月__介護給付_予防給付1総数("229", "旧市町村／償還（決定年月）／介護給付・予防給付①総数"),
    /**
     * コード:230 名称:旧市町村／償還（決定年月）／介護給付・予防給付②第２号被保険者分（再掲） 略称:定義なし
     */
    旧市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲("230", "旧市町村／償還（決定年月）／介護給付・予防給付②第２号被保険者分（再掲）"),
    /**
     * コード:231 名称:旧市町村／償還（決定年月）／介護給付・予防給付③総数特例分 略称:定義なし
     */
    旧市町村_償還_決定年月__介護給付_予防給付3総数特例分("231", "旧市町村／償還（決定年月）／介護給付・予防給付③総数特例分"),
    /**
     * コード:232 名称:旧市町村／償還（決定年月）／介護給付・予防給付④第２号被保険者分（再掲：特例分） 略称:定義なし
     */
    旧市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分("232", "旧市町村／償還（決定年月）／介護給付・予防給付④第２号被保険者分（再掲：特例分）"),
    /**
     * コード:233 名称:旧市町村／現物分／特定入所者介護（介護予防）サービス費①総数 略称:定義なし
     */
    旧市町村_現物分_特定入所者介護_介護予防_サービス費1総数("233", "旧市町村／現物分／特定入所者介護（介護予防）サービス費①総数"),
    /**
     * コード:234 名称:旧市町村／現物分／特定入所者介護（介護予防）サービス費②第２号被保険者分 略称:定義なし
     */
    旧市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分("234", "旧市町村／現物分／特定入所者介護（介護予防）サービス費②第２号被保険者分"),
    /**
     * コード:235 名称:旧市町村／償還（審査年月）／特定入所者介護（介護予防）サービス費①総数 略称:定義なし
     */
    旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数("235", "旧市町村／償還（審査年月）／特定入所者介護（介護予防）サービス費①総数"),
    /**
     * コード:236 名称:旧市町村／償還（審査年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分 略称:定義なし
     */
    旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分("236", "旧市町村／償還（審査年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分"),
    /**
     * コード:237 名称:旧市町村／償還（決定年月）／特定入所者介護（介護予防）サービス費①総数 略称:定義なし
     */
    旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数("237", "旧市町村／償還（決定年月）／特定入所者介護（介護予防）サービス費①総数"),
    /**
     * コード:238 名称:旧市町村／償還（決定年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分 略称:定義なし
     */
    旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分("238", "旧市町村／償還（決定年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分"),
    /**
     * コード:239 名称:旧市町村／高額介護（介護予防）サービス費 略称:定義なし
     */
    旧市町村_高額介護_介護予防_サービス費("239", "旧市町村／高額介護（介護予防）サービス費"),
    /**
     * コード:240 名称:旧市町村／高額医療合算介護（介護予防）サービス費 略称:定義なし
     */
    旧市町村_高額医療合算介護_介護予防_サービス費("240", "旧市町村／高額医療合算介護（介護予防）サービス費");

    private final RString code;
    private final RString fullName;

    private JigyohokokuGeppoHoseiHyoji(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 事業報告月報補正表示のコードを返します。
     *
     * @return 事業報告月報補正表示のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 事業報告月報補正表示の名称を返します。
     *
     * @return 事業報告月報補正表示の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 事業報告月報補正表示のコードと一致する内容を探します。
     *
     * @param code 事業報告月報補正表示のコード
     * @return {@code code} に対応する事業報告月報補正表示
     */
    public static JigyohokokuGeppoHoseiHyoji toValue(RString code) {

        for (JigyohokokuGeppoHoseiHyoji jigyohokokuGeppoHoseiHyoji : JigyohokokuGeppoHoseiHyoji.values()) {
            if (jigyohokokuGeppoHoseiHyoji.code.equals(code)) {
                return jigyohokokuGeppoHoseiHyoji;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("事業報告月報補正表示"));
    }
}
